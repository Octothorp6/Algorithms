package sorting;

/**
 * Sorting Algorithm: BubbleSort
 *
 * Time-Complexity:
 * Worst case: O(n^2)
 *
 * Stable or Unstable sort algorithm?
 * It is a stable sort algorithm because if the elements are the same, we do not swap.
 */

public class BubbleSort {
    public int[] sort(int[] array) {
        // iterate over the array perform the swapping until the last unsorted is 0.
        // after the operation is performed once, the last index will be sorted so we must decrement
        // so that we are no long indexing the last element in the array.
        for (int lastUnsorted = array.length - 1;  lastUnsorted > 0; lastUnsorted--) {
            for (int i = 0; i < lastUnsorted; i++) {
                if (array[i] > array[i + 1]) {
                    swap(array, i, i+ 1);
                }
            }
        }

        return array;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) {
            return;
        }

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
