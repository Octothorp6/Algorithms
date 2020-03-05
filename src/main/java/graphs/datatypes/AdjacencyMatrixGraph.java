package graphs.datatypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Adjacency-Matrix-Graph
 * This graph implementation uses an adjacency matrix to track adjacent nodes. You would use an adjacency matrix when
 * your graph is well connected. When the connections are large, the O(V^2) space is worth it.
 *
 * space-complexity: O(V^2)
 * time-complexity: isEdgePresent: O(1), Iteration of Edges of on a vertex O(V)
 */

public class AdjacencyMatrixGraph implements Graph {
    private int[][] adjacencyMatrix;
    private boolean isWeighted;
    private GraphType graphType;
    private int numVertices;

    public AdjacencyMatrixGraph(int numVertices, boolean isWeighted, GraphType graphType) {
        this.numVertices = numVertices;
        this.isWeighted = isWeighted;
        this.graphType = graphType;

        adjacencyMatrix = new int[numVertices][numVertices];

        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                 adjacencyMatrix[i][j] = 0;
            }
        }
    }

    @Override
    public int getIndegree(int v) {
        if (v >= numVertices || v < 0) {
            throw new IllegalArgumentException("Invalid vertex number.");
        }

        int inDegree = 0;
        for (int i = 0; i < numVertices; i++) {
            // IF the current vertex is present as an adjacent vertex for any other vertex, increment it's indegree
            if (adjacencyMatrix[i][v] != 0) {
                inDegree++;
            }
        }

        return inDegree;
    }


    @Override
    public GraphType TypeOfGraph() {
        return graphType;
    }

    @Override
    public void addEdge(int v1, int v2) {
        if (isWeighted) {
            throw new IllegalArgumentException("This graph is weighted.");
        }

        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Invalid vertex number.");
        }

        adjacencyMatrix[v1][v2] = 1;
        // IF the graph is undirected, the edge must be added to both
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = 1;
        }
    }

    @Override
    public void addEdge(int v1, int v2, int weight) {
        if (!isWeighted) {
            throw new IllegalArgumentException("This is not a weighted graph.");
        }

        if (v1 >= numVertices || v1 < 0 || v2 >= numVertices || v2 < 0) {
            throw new IllegalArgumentException("Invalid vertex number.");
        }

        adjacencyMatrix[v1][v2] = weight;
        if (graphType == GraphType.UNDIRECTED) {
            adjacencyMatrix[v2][v1] = weight;
        }
    }

    @Override
    public int getWeightedEdge(int v1, int v2) {
        return adjacencyMatrix[v1][v2];
    }

    @Override
    public int getNumVertices() {
        return numVertices;
    }

    @Override
    public List<Integer> getAdjacentVertices(int v) {
        if (v > numVertices || v < 0) {
            throw new IllegalArgumentException("Invalid vertex number.");
        }

        List<Integer> adjacentList = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            if(adjacencyMatrix[v][i] == 1) {
                adjacentList.add(i);
            }
        }
        // Always return the vertices in ascending order.
        Collections.sort(adjacentList);

        return adjacentList;
    }
}