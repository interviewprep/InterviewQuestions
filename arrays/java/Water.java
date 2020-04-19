/*
 * Given a histogram, find the maximum amount of water it can hold, if it rains (enough to fill the graph) over the histogram.
 * 
 */

package arrays.java;

/* A simple approach is to calculate the tallest bar to the left and right of each bar. The maximum water column above each bar
 * is minimum(left_tallest, right_tallest) - height of current bar.
 * With extra memory we can calculate this information for each bar in O(n) time.
 * 
 *  In the approach below, we try to do it without extra memory. 
 */


public class Water {

	public static int max(int[] A) {
		int start = 0;
		int end = A.length - 1;
		int max = 0;
		int leftmax = 0;
		int rightmax = 0;
		while (start <= end) {
			//the tallest bar so far from o to start
			leftmax = Math.max(leftmax, A[start]);
			//the tallest bar from n to end
			rightmax = Math.max(rightmax, A[end]);
			/* if leftmax is less than rightmax, we know that minimum(tallest_left_bar, tallest_righ_bar) for start is leftmax
			 * Therefore the height of water column above start is leftmax - A[start[
			 */
			if (leftmax < rightmax) {
				max += (leftmax - A[start]);
				start++;
			} else {
				/*
				 * Likewise if rightmax is less than leftmax, we can calculate the maximum height of water column above end.
				 */
				max += (rightmax - A[end]);
				end--;
			}
		}
		return max;
	}
	
	public static void main(String args[]) {
		int histogram[] = {5, 4,3, 5};
		System.out.println(max(histogram)); //0 + 1 + 2 + 0 = 3
	}

}
