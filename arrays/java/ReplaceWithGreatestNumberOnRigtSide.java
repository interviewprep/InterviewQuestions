/*
 * Replace an array of numbers by the greatest number on the right hand side
 */

package arrays.java;

public class ReplaceWithGreatestNumberOnRigtSide {

	public static void replace(int []A){
		if(A==null) return;
		int high=A[A.length-1],nexthigh=A[A.length-1];
		for (int i = A.length-1; i >= 0; i--) {
			nexthigh = Math.max(high, A[i]);
			A[i]=high;
			high=nexthigh;
		}
	}
	
	public static void main(String []args){
		int []A = {2,6,7,4,3,2};
		replace(A);
		for(int i: A){
			System.out.print(i+ " ");
		}
	}
}
