public class SearchRotatedArray {

	static int rotated_binary_search(int A[], int N, int key) {
		int L = 0;
		int R = N - 1;
		// loop through till left index value is less than Right
		while (L <= R) {
			// Avoid overflow, same as M=(L+R)/2 . Same as Binary Search to find
			// Midpoint of the array.
			int M = L + ((R - L) / 2);
			if (A[M] == key)
				return M;// if key found then return index position

			// check..the bottom half is sorted
			if (A[L] <= A[M]) {
				if (A[L] <= key && key < A[M])// check value of key greater than
												// lower index and less than mid
												// point
					R = M - 1;// Set the upper limit by decrementing Mid Index
								// position
				else
					L = M + 1;// set lower index value by incrementing the Mid
								// index position
			}
			// upper half is sorted
			else {
				if (A[M] < key && key <= A[R])// key is greater than Mid point
												// and less than Right most
												// index
					L = M + 1;// set lower index value by incrementing the
								// Midpoint
				else
					R = M - 1;// set upper limit by decrementing the midpoint
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] a = new int[] { 0, 1, 2, 3, 4 };
		rotated_binary_search(a, a.length, 4);

	}
}
