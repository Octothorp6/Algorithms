package sorting;

/**
 * Sorting Algorithm: Counting Sort
 *
 * Time-Complexity:
 * Best Case: O(n) - Linear time
 * Worst Case: O(n) - Linear time
 *
 * Stable or Unstable algorithm sort algorithm?
 * It is typically an unstable sorting algorithm unless you use a data structure like a linked list.
 *
 * Note: Counting sort is only a good candidate when the data set is within a reasonable range, and not a large
 * data-set. EX: sorting a 10 element array with elements ranging from 1-1000000, you would have to create a counting
 * array of length 1000000 just to sort 10 elements.
 */
public class CountingSort {
    public int[] sort(int[] array, int min, int max) {
        int[] countArray = new int[(max - min) + 1];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i] - min]++;
        }

        int j = 0;

        for (int i = min; i <= max; i++) {
            while(countArray[i - min] > 0) {
                array[j++] = i;
                countArray[i - min]--;
            }
        }

        return array;
    }
}
