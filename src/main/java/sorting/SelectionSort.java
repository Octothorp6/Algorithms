package sorting;

/**
 * Sorting Algorithm: Selection Sort
 *
 * Time-Complexity:
 * Best Case: O(n) - Linear Time
 * Worst Case: O(n^2) - Quadratic Time
 *
 * Stable or Unstable sort algorithm?
 * It is an unstable algorithm because it is possible we will be swapping
 * duplicates because on each operation we are moving the smaller value into the unsorted partition of the array.
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
