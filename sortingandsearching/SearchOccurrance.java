package sortingandsearching;


public class SearchOccurrance {

	public static int first(int arr[], int low, int high, int x, int n) {
		/*
		 * if x is present in arr[] then returns the index of FIRST occurrence of x in
		 * arr[0..n-1], otherwise returns -1
		 */

		if (high >= low) {
			// Find midpoint of the index of Array
			int mid = low + (high - low) / 2;
			// return index if repetative element is found
			if ((mid == 0 || x > arr[mid - 1]) && arr[mid] == x)
				return mid;
			// if search element is greater than mid element then search elements from the
			// Mid till end
			else if (x > arr[mid])
				return first(arr, (mid + 1), high, x, n);
			else
				// search first half of array till Midpoint
				return first(arr, low, (mid - 1), x, n);
		}
		return -1;
	}

	public static void main(String[] args) {

		int arr[] = { 1, 2, 2, 2, 2, 3, 4, 7, 8, 8 };
		int n = arr.length;
		int x = 8;
		System.out.println("First Occurrence = " + first(arr, 0, n - 1, x, n));

	}
}
