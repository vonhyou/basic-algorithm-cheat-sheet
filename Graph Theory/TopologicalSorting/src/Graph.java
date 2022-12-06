import java.util.ArrayList;
import java.util.List;

/**
 * Non-generic directed graph class
 *
 * @author moi@sfeng.ca
 */
public class Graph {
  private final int numberOfVertex;
  private final List<ArrayList<Integer>> edges;

  public Graph(int numberOfVertex) {
    this.numberOfVertex = numberOfVertex;
    this.edges = new ArrayList<>();

    // use adjacency list to store graph
    for (int i = 0; i < numberOfVertex; ++i) {
      this.edges.add(new ArrayList<>());
    }
  }

  public int getNumberOfVertex() {
    return numberOfVertex;
  }

  public List<ArrayList<Integer>> getEdges() {
    return edges;
  }

  /**
   * Add an edge from u to v
   *
   * @param u start point
   * @param v end point
   */
  public void addEdge(int u, int v) {
    edges.get(u).add(v);
  }
}
