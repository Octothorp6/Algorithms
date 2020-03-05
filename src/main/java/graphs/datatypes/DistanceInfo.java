package graphs.datatypes;

/**
 * This class will hold the distance information of any vertex. The distance specified is the distance from the source
 * node and the last vertex is the last vertex just before the current one when traversing from the source node. IF the
 * graph is weighted, we will initialize distance to INFINITY because in a weighted graph there can be negative weights
 * and we need to be able to account for that.
 */

public class DistanceInfo {
    private int distance;
    private int lastVertex;

    public DistanceInfo(boolean weighted) {
        this.distance = weighted ? Integer.MAX_VALUE : -1;
        this.lastVertex = -1;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public void setLastVertex(int lastVertex) {
        this.lastVertex = lastVertex;
    }

    public int getDistance() {
        return distance;
    }

    public int getLastVertex() {
        return lastVertex;
    }
}