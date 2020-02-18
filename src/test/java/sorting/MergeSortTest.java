package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeSortTest {
    private final int[] TEST_ARRAY = {1,5,41,23,33,2,7,10,21,19};
    private final int[] SORTED_ARRAY = {1,2,5,7,10,19,21,23,33,41};
    private final int[] DESCENDING_ARRAY = {41,33,23,21,19,10,7,5,2,1};
    private final MergeSort mergeSort = new MergeSort();

    @Test
    void sort() {
        int[] outputArray = mergeSort.sort(TEST_ARRAY, 0, TEST_ARRAY.length);

        assertArrayEquals(outputArray, SORTED_ARRAY);
    }

    @Test
    void descendingSort() {
        int[] outputArray = mergeSort.descendingSort(TEST_ARRAY,0,TEST_ARRAY.length);

        assertArrayEquals(outputArray,DESCENDING_ARRAY);
    }
}