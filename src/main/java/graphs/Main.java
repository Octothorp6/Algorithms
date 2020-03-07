package graphs;

import graphs.algorithms.ShortestDistance;
import graphs.datatypes.AdjacencyMatrixGraph;
import graphs.datatypes.Graph;

public class Main {
    public static void main(String[] args) {
        Graph graph = new AdjacencyMatrixGraph(5, true, Graph.GraphType.DIRECTED);
        graph.addEdge(0,2,4);
        graph.addEdge(2,1,7);
        graph.addEdge(1,4,11);
        graph.addEdge(1,3,-2);
        graph.addEdge(4,3,5);
        graph.addEdge(3,4,6);

        ShortestDistance shortestDistance = new ShortestDistance();
        shortestDistance.findShortestPath(graph,0,4);
    }
}
