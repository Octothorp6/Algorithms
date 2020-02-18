package sorting;

/**
 * Sorting Algorithm: Insertion Sort
 *
 * Time-Complexity:
 * Best Case: O(n) Linear Time
 * Worst Case: O(n^2) Quadratic time
 *
 * Stable or Unstable sort algorithm?
 * It is a stable algorithm because we are inserting elements from right to left, essentially keeping the order
 * of insertion if there were duplicates.
 */

public class InsertionSort {
    // Iterative implementation
    public int[] sort(int[] array) {
        // Iterate the array starting at the second position because the element in the
        // first position is assumed to be in the sorted partition on the first iteration.
        for (int firstUnsorted = 1; firstUnsorted < array.length; firstUnsorted++) {
            int newElement = array[firstUnsorted];

            int i;
            // We want to keep looking for the correct insertion position as long as we haven't arrived
            // at the beginning of the array and the element at the sorted partition is greater than the
            // element we are trying to insert (newElement). Decrement because we are going right to left.
            for (i = firstUnsorted; i > 0 && array[i - 1] > newElement; i--) {
                array[i] = array[i - 1];
            }

            array[i] = newElement;
        }

        return array;
    }

    // Recursive implementation
    public int[] sort(int[] array, int numItems) {
        // if numItems is less than 2, the array is already sorted by definition
        if (numItems < 2) {
            return array;
        }

        sort(array, numItems - 1);

        int newElement = array[numItems - 1];

        int i;

        for (i = numItems - 1; i > 0 && array[i - 1] > newElement; i--) {
            array[i] = array[i - 1];
        }

        array[i] = newElement;

        return array;
    }
}
