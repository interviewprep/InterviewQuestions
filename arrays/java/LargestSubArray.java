/*
 * Given an array of integers, find the length of the largest increasing sub array.
 * For example, 50, 60,20, 30, 40, 2; the largest increasing sub array is 20,30,40.
 */

package arrays.java;

public class LargestSubArray {

	public static int largestSubArray(int array[]) {
		int i = 0, j = 1;
		// assume array of min length 1
		int max_length = 1;
		while (j < array.length) {
			if (array[j] > array[i]) {
				j++;
				if ((j - i) > max_length) {
					max_length = (j - i);
				}
			} else {

				i = j;
				j = i + 1;
			}
		}
		return max_length;
	}
	
	public static void main(String args[]) {
		
		int array[] = {50, 10, 20, 30};
		System.out.println(largestSubArray(array));
	}
}
