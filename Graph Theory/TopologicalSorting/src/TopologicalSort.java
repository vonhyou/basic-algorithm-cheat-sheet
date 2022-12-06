import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Implementation of topological sorting
 *
 * @author moi@sfeng.ca
 */
public class TopologicalSort {
  private final Graph graph;
  private final Queue<Integer> queue;
  private final boolean[] isVisited;
  private final List<Integer> result;

  private TopologicalSort(Graph graph) {
    this.graph = graph;
    this.queue = new LinkedList<>();
    this.isVisited = new boolean[graph.getNumberOfVertex()];
    this.result = new ArrayList<>();
  }

  /**
   * A static factory of TopologicalSort class
   *
   * @param graph the graph to be sorted
   * @return the result of topological sort
   */
  public static List<Integer> of(Graph graph) {
    TopologicalSort topologicalSort = new TopologicalSort(graph);
    topologicalSort.sort();
    return topologicalSort.result;
  }

  /**
   * Core algorithm
   */
  private void sort() {
    int[] inDegree = getInDegree(graph);

    // Enqueue the vertices with a `0` indegree and mark them as visited
    for (int i = 0; i < graph.getNumberOfVertex(); i++) {
      if (inDegree[i] == 0) {
        queue.add(i);
        isVisited[i] = true;
      }
    }

    while (!queue.isEmpty()) {
      int u = queue.poll();
      result.add(u);

      // Enqueue the succeeding vertices and
      //   update the indegree of them
      for (int v : graph.getEdges().get(u)) {
        inDegree[v]--;
        if (inDegree[v] == 0 && !isVisited[v]) {
          queue.add(v);
          isVisited[v] = true;
        }
      }
    }
  }

  /**
   * A help method, to generate the indegree of every vertices
   *
   * @param graph the graph to be processed
   * @return an array, contains the indegree of each vertex
   */
  private int[] getInDegree(Graph graph) {
    int[] inDegree = new int[graph.getNumberOfVertex()];
    List<ArrayList<Integer>> adjList = graph.getEdges();

    for (ArrayList<Integer> u : adjList) {
      for (int v : u) {
        inDegree[v]++;
      }
    }

    return inDegree;
  }
}
