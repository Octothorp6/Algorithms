package search;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {
    private final int[] ARRAY = {0,4,1,5,7,8,3,6,11};
    private BinarySearch binarySearch;

    @BeforeEach
    void setUp() {
        binarySearch = new BinarySearch();
    }

    @Test
    void binarySearch() {
        assertEquals(1, binarySearch.binarySearchIterative(ARRAY,0,ARRAY.length -1, 1));
    }

    @Test
    void binarySearchIterative_ShouldFail() {
        assertEquals(-1, binarySearch.binarySearchIterative(ARRAY,0,ARRAY.length - 1,33));
    }

    @Test
    void binarySearchRecursive() {
        assertEquals(1, binarySearch.binarySearchRecursive(ARRAY, 1));
    }

    @Test
    void binarySearchRecursive_ShouldFail() {
        assertEquals(-1, binarySearch.binarySearchRecursive(ARRAY, 33));
    }
}