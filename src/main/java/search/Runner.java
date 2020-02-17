package search;


public class Runner {
    private static int[] ARRAY = {0,4,1,5,7,8,3,6,11};

    public static void main(String[] args) {
        BinarySearch bn = new BinarySearch();
        System.out.println(bn.binarySearchRecursive(ARRAY,11));
        System.out.println(bn.binarySearchIterative(ARRAY,0,ARRAY.length - 1, 11));
    }
}
