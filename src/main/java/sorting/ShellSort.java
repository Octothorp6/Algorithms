package sorting;

/**
 * Sorting Algorithm: Shell Sort
 *
 * Time-Complexity:
 * Best Case: O(n) Linear Time (truly depends on the gap value)
 * Worst Case: O(n^2) Quadratic time
 *
 *
 * Stable or Unstable algorithm sort algorithm?
 * It is an unstable algorithm because we are going to shift the elements in the pre-insertion phase. In that event,
 * it is very possible that the right-most element will be shifted in front of the left-most element thus rendering
 * it an unstable algorithm.
 */

public class ShellSort {
    public int[] sort(int[] array) {
        // outer loop will initialize the gap value and reduce it over each iteration (divide by 2 until it is 1)
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            // inner loop will use the gap value to compare values
            for (int i = gap; i < array.length; i++) {
                int newElement = array[i];

                int j = i;
                 while (j >= gap && array[j - gap] > newElement) {
                     array[j] = array[j - gap];

                     j -= gap;
                 }

                 array[j] = newElement;
            }
        }

        return array;
    }
}
