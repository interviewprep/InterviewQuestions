package sortingandsearching;

import arrays.Utilities;

/* Find the given number in a sorted array that has been rotated 0 or more times
 * Sorted array rotated once: 50 10 20 30 40
 */

// Every number is part of at least one sorted sequence,  to its left (from start to the number) or to its right 
// (from the number to  end index). If the key is not a part of the sorted sequence, it is part of the other half.

public class SearchRotatedSortedArray {

	private static int rotatedArraySearch(int array[], int start, int end, int key) {

		if (start <= end) {

			int mid = start + (end - start) / 2;

			if (array[mid] == key) {
				return mid;
			} else if (array[mid] >= array[start]) { // lhs is sorted
				if (key >= array[start] && key < array[mid]) {
					return rotatedArraySearch(array, start, mid - 1, key);
				} else {
					return rotatedArraySearch(array, mid + 1, end, key);
				}
			} else { // (array[mid] < array[end]); rhs is sorted
				if (key > array[mid] && key <= array[end]) {
					return rotatedArraySearch(array, mid + 1, end, key);
				} else {
					return rotatedArraySearch(array, start, mid - 1, key);
				}
			}
		}

		return -1;
	}

	public static int rotatedArraySearch(int array[], int key) {
		return rotatedArraySearch(array, 0, array.length - 1, key);
	}

	public static void main(String[] args) {
		int[] a = new int[] { 50, 10, 30, 40 };
		System.out.println("30: " + (rotatedArraySearch(a,  30)));
		System.out.println("50: " + (rotatedArraySearch(a, 50)));
		System.out.println("70: " + (rotatedArraySearch(a, 70)));
	}

}
