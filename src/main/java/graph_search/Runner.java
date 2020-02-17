package graph_search;

/*Task:
 *
 */
public class Runner {

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addNode(1);
        graph.addNode(2);
        graph.addEdge(1,2);
        graph.addNode(3);
        graph.addEdge(2,3);
        graph.addNode(4);
        graph.addEdge(3,4);
        graph.addNode(5);
        graph.addNode(6);
        graph.addEdge(5,6);

        System.out.println(graph.hasPathBFS(1,6));
    }
}
