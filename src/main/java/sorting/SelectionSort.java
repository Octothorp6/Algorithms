package sorting;

/**
 * Sorting Algorithm: Selection Sort
 */
public class SelectionSort {
    public int[] sort(int[] array) {
        for (int lastUnsorted = array.length - 1; lastUnsorted > 0; lastUnsorted--) {
            // initialize the largest as 0 temporarily since we have not
            // checked the largest value on the first loop over the array.
            int largest = 0;

            // start at 1 so that we can check if the element at position 0 in the array is larger
            // than the element at position 1. If so, will update the largest value.
            for (int i = 1; i <= lastUnsorted; i++) {
                if (array[i] > array[largest]) {
                    largest = i;
                }
            }
            swap(array, largest, lastUnsorted);
        }

        return array;
    }

    private void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

}
