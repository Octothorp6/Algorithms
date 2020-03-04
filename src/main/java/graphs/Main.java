package graphs;

import graphs.datatypes.AdjacencySetGraph;
import graphs.datatypes.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new AdjacencySetGraph(5, Graph.GraphType.DIRECTED);
        graph.addEdge(0,2);
        graph.addEdge(2,1);
        graph.addEdge(1,4);
        graph.addEdge(4,3);
        graph.addEdge(3,0);

        GraphHelper graphHelper = new GraphHelper();
        graphHelper.findShortestPath(graph,0,4);
    }
}
