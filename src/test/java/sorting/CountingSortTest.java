package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountingSortTest {
    private final int[] TEST_ARRAY = {2,5,4,7,3,2,4,1,6,9};
    private final int[] SORTED_ARRAY = {1,2,2,3,4,4,5,6,7,9};
    private final CountingSort countingSort = new CountingSort();

    @Test
    void sort() {
        int[] outputArray = countingSort.sort(TEST_ARRAY, 1,10);

        assertArrayEquals(outputArray, SORTED_ARRAY);
    }
}