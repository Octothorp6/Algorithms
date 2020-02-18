package sorting;

/**
 * Sorting Algorithm: Merge Sort
 *
 * Time-Complexity:
 * Best Case: O(nlogn) Logarithmic time.
 * Worst Case: O(nlogn) Logarithmic time.
 *
 * Stable or Unstable algorithm sort algorithm?
 * It is a Stable sort algorithm because when we do the merging we check whether the element in the right array is
 * greater than the element on the left array. If they are equal, the relative ordering of the duplicate elements will
 * be preserved.
 */

public class MergeSort {
    public int[] sort(int[] array, int start, int end) {
        // if the array is of length 0 or 1, it is already sorted
        if (end - start < 2) {
            return array;
        }

        int mid = (start + end) / 2;
        // call sort recursively on the left partition
        sort(array, start, mid);
        // call sort recursively on the right partition
        sort(array, mid, end);
        // merge the elements once both partitions have been sorted
        merge(array, start, mid, end);

        return array;
    }

    private void merge(int[] array, int start, int mid, int end) {
        if (array[mid - 1] <= array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            // compare the current element in the left partition arr[i] to the element in the right partition arr[j]
            // and write the smallest of the two to the temp array. The equal sign maintains the stable property.
            temp[tempIndex++] = array[i] <= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

    /*
     * ==============================================================================================
     *                              SORT IN DESCENDING ORDER
     * ==============================================================================================
     */

    public int[] descendingSort(int[] array, int start, int end) {
        if (end - start < 2) {
            return array;
        }

        int mid = (start + end) / 2;

        descendingSort(array, start, mid);

        descendingSort(array, mid, end);

        descendingMerge(array, start, mid, end);

        return array;
    }

    private void descendingMerge(int[] array, int start, int mid, int end) {
        if (array[mid - 1] >= array[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];

        while (i < mid && j < end) {
            temp[tempIndex++] = array[i] >= array[j] ? array[i++] : array[j++];
        }

        System.arraycopy(array, i, array, start + tempIndex, mid - i);
        System.arraycopy(temp, 0, array, start, tempIndex);
    }

}
