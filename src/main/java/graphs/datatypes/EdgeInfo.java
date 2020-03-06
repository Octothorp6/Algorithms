package graphs.datatypes;

public class EdgeInfo {
    private Integer vertex1;
    private Integer vertex2;
    private Integer weight;

    public EdgeInfo(Integer vertex1, Integer vertex2, Integer weight) {
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
    }

    public Integer getVertex1() {
        return vertex1;
    }

    public void setVertex1(Integer vertex1) {
        this.vertex1 = vertex1;
    }

    public Integer getVertex2() {
        return vertex2;
    }

    public void setVertex2(Integer vertex2) {
        this.vertex2 = vertex2;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return String.valueOf(vertex1) + String.valueOf(vertex2);
    }
}
