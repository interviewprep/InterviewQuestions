/*
 * Music Player: Given an array of Integers, pick a number at random without repetition till all the numbers have been picked.
 */
package arrays.java;

import java.util.Random;

/*
 * Move the randomly picked number to the end of the array and forget about it.
 * Alternative solutions include storing randomly picked numbers in hash-tables to prevent duplicate picking
 * but don't guarantee completion time. 
 */

public class MusicPlayer {
	public static void random(int[] A) {
		Random rand = new Random();
		for (int i = A.length - 1; i >= 0; i--) {
			int j = rand.nextInt(i + 1);
			System.out.println(A[j]);
			swap(A, j, i);
		}
	}

	public static void swap(int[] A, int i, int j) {
		int k = A[i];
		A[i] = A[j];
		A[j] = k;
	}
	
	public static void main(String args[]) {
		int array[] = {1, 3, 2, 5, 4};
		random(array);
	}

}
