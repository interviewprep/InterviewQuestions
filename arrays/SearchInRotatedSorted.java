package arrays;

public class SearchInRotatedSorted {

	public static void main(String[] args) {
		System.out.println(rotated_binary_search(new int[] { 4, 5, 6, 7, 0, 1,
				2 }, 7, 1));
	}

	static int rotated_binary_search(int A[], int N, int key) {
		int l = 0, h = A.length-1;
		while (l <= h) {
			int m = (l + h) / 2;
			if (A[m] == key) {
				return m;
			}
			if (A[l] <= A[m]) {
				if (A[l] <= key && key < A[m]) {
					h = m - 1;
				} else {
					l = m + 1;
				}
			} else {
				if (A[m] < key && key <= A[h]) {
					l = m + 1;
				} else {
					h = m - 1;
				}
			}
		}
		return 0;
	}
}
