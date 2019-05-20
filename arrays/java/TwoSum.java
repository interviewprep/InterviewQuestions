/*
 * Given a sorted array of Integers, can you find if there are two numbers that add up to a given target?
 */

package arrays;

public class TwoSum {
	
	public static boolean twoPointerMethod(int[] A, int target) {
		if (A == null)
			return false;
		int start = 0, end = A.length - 1;
		while (start < end) {
			int currentSum = A[start] + A[end];
			if (currentSum == target)
				return true;
			else if (currentSum < target)
				start++;
			else
				end--;
		}
		return false;
	}

	public static boolean binarySearchMethod(int[] A, int target) {
		
		for (int a: A) {
			if (binarySearch(A, target-a))
				return true;
		}
		return false;
	}
	
	private static boolean binarySearch(int A[], int target) {
		
		int lo = 0, hi = A.length - 1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			if (A[mid] == target)
				return true;
			else if (A[mid] < target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}

		return false;
	}


	public static void main(String[] args) {
		int[] a = { 5, 6, 7, 12, 13 };
		
		System.out.println(twoPointerMethod(a, 20));
		System.out.println(twoPointerMethod(a, 50));
		System.out.println(binarySearchMethod(a, 20));
		System.out.println(binarySearchMethod(a, 50));
	}

}
