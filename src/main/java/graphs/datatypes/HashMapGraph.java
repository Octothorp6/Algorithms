package graphs.datatypes;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * This class contains a breadth-first and depth-first graph search implementation.
 */
public class HashMapGraph {
    private int V;
    private HashMap<Integer,Node> nodeLookup;

    public static class Node {
        private int id;
        LinkedList<Node> adjacent = new LinkedList<>();

        private Node(int id) {
            this.id = id;
        }
    }

    public HashMapGraph(int v) {
        this.V = v;
        nodeLookup = new HashMap<>();
        for (int i = 0; i < V; i++) {
            nodeLookup.put(i, new Node(i));
        }
    }

    private Node getNode(int id) {
        return nodeLookup.get(id);
    }

    public void addEdge(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        s.adjacent.add(d);
    }

    public boolean hasPathDFS(int source, int destination) {
        Node s = getNode(source);
        Node d = getNode(destination);
        HashSet<Integer> visited = new HashSet<>();
        return hasPathDFS(s, d, visited);
    }

    private boolean hasPathDFS(Node source, Node destination, HashSet<Integer> visited) {
        if (visited.contains(source.id)) {
            return false;
        }
        // make sure to add to the visited set so that we're not doing any unnecessary checks
        visited.add(source.id);

        if (source == destination) {
            return true;
        }

        for (Node child : source.adjacent) {
            if (hasPathDFS(child, destination, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasPathBFS(int source, int destination) {
        return hasPathBFS(getNode(source),getNode(destination));
    }

    private boolean hasPathBFS(Node source, Node destination) {
        LinkedList<Node> nextToVisit = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();

        nextToVisit.add(source);
        while(!nextToVisit.isEmpty()) {
            Node node = nextToVisit.remove();
            if (node == destination) {
                return true;
            }

            if (visited.contains(node.id)) {
                continue;
            }

            visited.add(node.id);
            // add all the nodes children to be visited for the next iteration of the while loop
            for (Node child : node.adjacent) {
                nextToVisit.add(child);
            }

        }
        return false;
    }
}
