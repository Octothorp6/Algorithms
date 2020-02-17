package search;

import java.util.Arrays;

/**
 * This class contains a binary search implementation both iteratively and recursively. IF the element is found, it will
 * return the index of the element. If the element in question is not found, it will return -1.
 */
public class BinarySearch {

    public int binarySearchIterative(int[] array, int left, int right, int x) {
        Arrays.sort(array);

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x) {
                return mid;
            } else if (array[mid] > x) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] array, int x) {
        Arrays.sort(array);
        return binarySearchRecursive(array, 0, array.length - 1, x);
    }

    private int binarySearchRecursive(int[] array, int left, int right, int x) {
        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (x == array[mid]) {
            return mid;
        } else if (x < array[mid]) {
            return binarySearchRecursive(array, left, mid - 1, x);
        } else {
            return binarySearchRecursive(array, mid + 1, right, x);
        }
    }
}
