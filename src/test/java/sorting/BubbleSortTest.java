package sorting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    private final int[] TEST_ARRAY = {1,5,41,23,33,2,7,10,21,19};
    private final int[] SORTED_ARRAY = {1,2,5,7,10,19,21,23,33,41};
    private final BubbleSort bubbleSort = new BubbleSort();

    @Test
    void sort() {
        int[] outputArray = bubbleSort.sort(TEST_ARRAY);

        assertArrayEquals(outputArray, SORTED_ARRAY);
    }
}