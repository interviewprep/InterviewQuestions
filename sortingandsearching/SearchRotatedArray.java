package sortingandsearching;
public class SearchRotatedArray {

	static int rotatedBinarySearch(int A[], int N, int key) {
		int leftIndex = 0;
		int rightIndex = N - 1;
		// loop through till left index value is less than Right
		while (leftIndex <= rightIndex) {
			// Avoid overflow, same as M=(L+R)/2 . Same as Binary Search to find
			// Midpoint of the array.
			int midPoint = leftIndex + ((rightIndex - leftIndex) / 2);
			if (A[midPoint] == key)
				return midPoint;// if key found then return index position

			// check..the bottom half is sorted
			if (A[leftIndex] <= A[midPoint]) {
				if (A[leftIndex] <= key && key < A[midPoint])// check value of key greater than
												// lower index and less than mid
												// point
					rightIndex = midPoint - 1;// Set the upper limit by decrementing Mid Index
								// position
				else
					leftIndex = midPoint + 1;// set lower index value by incrementing the Mid
								// index position
			}
			// upper half is sorted
			else {
				if (A[midPoint] < key && key <= A[rightIndex])// key is greater than Mid point
												// and less than Right most
												// index
					leftIndex = midPoint + 1;// set lower index value by incrementing the
								// Midpoint
				else
					rightIndex = midPoint - 1;// set upper limit by decrementing the midpoint
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 3, 4 };
		rotatedBinarySearch(a, a.length, 4);

	}
}
