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
