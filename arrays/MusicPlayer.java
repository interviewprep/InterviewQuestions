/*
 * Music Player: Given an array of Integers, pick a number at random without repetition.
 */

package arrays;

import java.util.Random;

public class MusicPlayer {
	public static void random(int []A){
		Random rand = new Random();
		for (int i = A.length-1; i>=0; i--) {
			int j= rand.nextInt(i+1);
			System.out.println(A[j]);
			swap(A,j,i);
		}
	}
	
	public static void swap(int []A, int i , int j){
		int k = A[i];
		A[i] = A[j];
		A[j] = k;
	}

}
