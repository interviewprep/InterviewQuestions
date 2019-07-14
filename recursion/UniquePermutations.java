/* Print unique permutations of an array of numbers 
 * {2, 2} has only one permutation
 * {2,3} has two permutations
 */
package recursion;

import java.util.HashSet;
import java.util.Set;

/*
 * Generate permutations, while making sure that  if a number i 
 * is used at the ith position, don't use it again
 */
public class UniquePermutations {
	public static int printUniquePermutations(int array[],int num) {
		int sum=0;
	    if (num==array.length) {
	    	 for (int i: array) 
	    		 System.out.print(i);
	    	 System.out.println("");
	    	  return 1;
	    }
	    Set<Integer> set = new HashSet<>();    
		for (int i=num; i<array.length; i++) {			
			if (!set.contains(array[i])) {
				set.add(array[i]);
				swap(array, num, i);
				// get all permutations starting with array[i]...
				sum = sum + printUniquePermutations(array, num+1);
				swap(array, num, i);
			}
		}
		return sum;
	}
	private static void swap(int array[], int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	public static void main(String args[]) {
		int array1[] = {2,2,2};
		System.out.println(printUniquePermutations(array1,0));
		int array2[] = {2,3,2};
		System.out.println(printUniquePermutations(array2,0));
		int array3[] = {2,3,4};
		System.out.println(printUniquePermutations(array3,0));
			
	}
	

}
