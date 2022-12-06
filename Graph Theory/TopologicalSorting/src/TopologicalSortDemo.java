public class TopologicalSortDemo {
  public static void main(String[] args) {
    Graph graph = new Graph(7);

    graph.addEdge(1, 3);
    graph.addEdge(1, 4);
    graph.addEdge(2, 4);
    graph.addEdge(3, 5);
    graph.addEdge(3, 6);
    graph.addEdge(3, 7);
    graph.addEdge(4, 6);
    graph.addEdge(4, 7);

    System.out.println(TopologicalSort.of(graph));
  }
}
