package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuickSortTest {
    private final int[] TEST_ARRAY = {1,5,41,23,33,2,7,10,21,19};
    private final int[] SORTED_ARRAY = {1,2,5,7,10,19,21,23,33,41};
    private final QuickSort quickSort = new QuickSort();

    @Test
    void sort() {

        int[] outputArray = quickSort.sort(TEST_ARRAY, 0, TEST_ARRAY.length);

        assertArrayEquals(outputArray, SORTED_ARRAY);
    }
}