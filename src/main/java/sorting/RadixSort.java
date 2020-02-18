package sorting;

/**
 * Sorting Algorithm: Radix Sort
 *
 * Time-Complexity:
 * Best Case: O(n) because we're making assumptions about the data we are using.
 * Worst Case: O(nLogn)
 */
public class RadixSort {
    public int[] sort(int[] array, int radix, int width) {
        for (int i = 0; i < width; i++) {
            singleSort(array, i, radix);
        }
        return array;
    }

    private void singleSort(int[] array, int position, int radix) {
        int numItems = array.length;
        int[] countArray = new int[radix];

        // adjust the count so that count[i] now contains
        // actual position of this digit in array[]
        for (int value : array) {
            countArray[getDigit(position, value, radix)]++;
        }

        for (int j = 1; j < radix; j++) {
            countArray[j] += countArray[j - 1];
        }

        int[] temp = new int[numItems];

        for (int tempIndex = numItems - 1; tempIndex >= 0; tempIndex--) {
            temp[--countArray[getDigit(position, array[tempIndex], radix)]] = array[tempIndex];
        }

        for (int i = 0; i < numItems; i++) {
            array[i] = temp[i];
        }
    }

    private int getDigit(int position, int value, int radix) {
        return value / (int) Math.pow(10, position) % radix;
    }
}
