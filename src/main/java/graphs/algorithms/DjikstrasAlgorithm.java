package graphs.algorithms;

import graphs.datatypes.DistanceInfo;
import graphs.datatypes.Graph;
import graphs.datatypes.VertexInfo;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * This is an implementation of Djikstra's path finding algorithm using a distance table. This is an example of a
 * "Greedy Algorithm".
 */
public class DjikstrasAlgorithm {
    // Helper method needed to build the distance table for us
    private Map<Integer, DistanceInfo> buildDistanceTable(Graph graph, int source) {
        Map<Integer, DistanceInfo> distanceTable = new HashMap<>();
        // This Priority queue will return nodes in order of the shortest distance from the source. "Greedy solution"
        PriorityQueue<VertexInfo> queue = new PriorityQueue<>((v1, v2) -> {
            return ((Integer) v1.getDistance()).compareTo(v2.getDistance());
        });
        Map<Integer, VertexInfo> vertexInfoMap = new HashMap<>();
        // For each vertex in the graph we will need to initialize a distance info entry.
        for (int i = 0; i < graph.getNumVertices(); i++) {
            distanceTable.put(i, new DistanceInfo(true));
        }

        distanceTable.get(source).setDistance(0);
        distanceTable.get(source).setLastVertex(0);
        // Initialize and Add the source to the priority queue since that is the node we would like to explore first.
        VertexInfo sourceVertex = new VertexInfo(source, 0);
        queue.add(sourceVertex);
        vertexInfoMap.put(source, sourceVertex);

        while (!queue.isEmpty()) {
            // Access priority queue to find the closest vertex.
            VertexInfo vertexInfo = queue.poll();
            int currentVertex = vertexInfo.getVertexId();
            // Iterate over all of the graph vertices
            for (Integer neighbor : graph.getAdjacentVertices(currentVertex)) {
                // Get the new distance and account for the weighted edge.
                int distance = distanceTable.get(currentVertex).getDistance() +
                        graph.getWeightedEdge(currentVertex, neighbor);
                // Check if we have found a shorter path to the neighbor. If so, update the existing distance and vertex.
                if (distance < distanceTable.get(neighbor).getDistance()) {
                    distanceTable.get(neighbor).setDistance(distance);
                    distanceTable.get(neighbor).setLastVertex(currentVertex);
                    // Since we've found a new shortest path to the neighbor, remove the old one from the queue.
                    VertexInfo neighborVertexInfo = vertexInfoMap.get(neighbor);
                    if (neighborVertexInfo != null) {
                        queue.remove(neighborVertexInfo);
                    }
                    // Reassign the neighbor with the new values and add to queue.
                    neighborVertexInfo = new VertexInfo(neighbor, distance);
                    queue.add(neighborVertexInfo);
                    vertexInfoMap.put(neighbor, neighborVertexInfo);
                }
            }
        }
        return distanceTable;
    }

    public void findShortestPath(Graph graph, Integer source, Integer destination) {
        Map<Integer, DistanceInfo> distanceTable = buildDistanceTable(graph, source);
        // We will use a stack since we will be doing backtracking, and will start with the destination node.
        Stack<Integer> stack = new Stack<>();
        stack.push(destination);

        int previousVertex = distanceTable.get(destination).getLastVertex();
        while (previousVertex != -1 && previousVertex != source) {
            // Add the last vertex of every node and add it to the stack
            stack.push(previousVertex);
            previousVertex = distanceTable.get(previousVertex).getLastVertex();
        }
        // IF there was no valid last vertex in the distance table, no path exists from the source node to destination.
        if (previousVertex == -1) {
            System.out.println("There is no path from node: " + source + " to node: " + destination);
        } else {
            System.out.print("Shortest path is: " + source);
            while (!stack.isEmpty()) {
                System.out.print(" -> " + stack.pop());
            }
            System.out.println(" We have now completed Djikstras Algorithm.");
        }
    }

}
