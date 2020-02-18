package sorting;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class RadixSortTest {
    private final int[] TEST_ARRAY = {4725, 4586, 1330, 8792, 1594, 5729};
    private final int[] SORTED_ARRAY = {1330, 1594, 4586, 4725, 5729, 8792};
    private final RadixSort radixSort  = new RadixSort();

    @Test
    void sort() {
        int[] outputArray = radixSort.sort(TEST_ARRAY, 10, 4);

        assertArrayEquals(outputArray, SORTED_ARRAY);
    }
}