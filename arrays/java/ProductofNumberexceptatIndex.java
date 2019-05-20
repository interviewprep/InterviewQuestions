/*
 * Given an array of integers, return an array where the element at i is the product of all the numbers except the number 
 * at location i in the original array.
 * For example if input array is {2, 3, 4} output is {12, 8, 6}.
 */ 

package arrays;

/* Multiplying all numbers and diving by the ith number may lead to overflow, even if there is a valid answer
 * Sometimes using the division operator may be prohibited as a part of the question
 * In this solution we try to solve it without the division operator
 */


public class ProductofNumberexceptatIndex {

	public static int[] product(int []A){
		int []productL = new int[A.length];
		int []productR = new int[A.length];
		int []result = new int[A.length];
		productL[0]=1;
		productR[A.length-1]=1;
		//calculate the product of all numbers to the left of i
		for (int i = 1; i < A.length; i++) {
			productL[i] = productL[i-1]*A[i-1]; 
		}
		//calculate the product of all numbers to the right i
		for (int i = A.length-2; i >= 0; i--) {
			productR[i] = productR[i+1]*A[i+1];
		}
	   //left product and right product gives the product of all numbers except array[i]
		for (int i = 0; i < A.length; i++) {
			result[i] = productL[i]*productR[i];
		}
		return result;
	}
	
	public static void main(String []args){
		int []A = {2,5,6,3,4};
		int []result = product(A);
		for(int i: result){
			System.out.println(i);
		}
	}
}
