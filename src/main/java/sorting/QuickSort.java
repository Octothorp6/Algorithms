package sorting;

/**
 * Sorting Algorithm: Quick Sort
 *
 * Time-Complexity:
 * Best Case: O(n log n) - base 2, otherwise known as Linearithmic time
 * Worst Case: O(n^2) Quadratic time
 *
 * Stable or Unstable algorithm sort algorithm?
 * It is an unstable algorithm because when we are alternating between partitions, there is no guarantee that the
 * the relative order of duplicate elements will be preserved.
 */
public class QuickSort {
    public int[] sort(int[] array, int start, int end) {
        if (end - start < 2) {
            return array;
        }

        // figure out where the pivot is in the array
        int pivotIndex = partition(array, start, end);
        // sort the left partition
        sort(array, start, pivotIndex);
        // sort the right partition
        sort(array,pivotIndex + 1, end);

        return array;
    }

    private int partition(int[] array, int start, int end) {
        // using the first element as the pivot
        int pivot = array[start];
        // will traverse from left to right
        int i = start;
        // will traverse from right to left
        int j = end;
        // we will break out of the loop if I crosses J
        while (i < j) {
            // empty loop body used to decrement j
            while(i < j && array[--j] >= pivot);
            // if we broke out of the above loop, we've found an element smaller than the pivot so we must swap
            if (i < j) {
                array[i] = array[j];
            }
            // empty loop body used to increment i
            while(i < j && array[++i] <= pivot);
            // if we broke out of the above loop, we've found an element larger than the pivot so we must swap
            if (i < j) {
                array[j] = array[i];
            }
        }

        array[j] = pivot;
        return j;
    }
}
