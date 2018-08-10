package sortingandsearching;

import arrays.Utilities;

public class RemoveDuplicates {
	
	public static void removeDuplicates(int array[]) {
		int i =0;
		int j =1;
		while (j < array.length) {
			if (array[j]== array[i]) {
			  j++;
			  
			} else {
				array[i+1] = array[j];
				i++;j++;
			}
			
		}
		for (;i+1<array.length;i++) {
			array[i+1] = 0;
		}
		
	}
	
	public static void main(String[] args) {
		int[] a = new int[] { 10, 20, 30, 40 };
		removeDuplicates(a);
		Utilities.printArray(a);
		int[] b = new int[] { 10, 20, 30, 40, 40, 40, 50};
		removeDuplicates(b);
		Utilities.printArray(b);
		
		int[] c = new int[] { 10, 20, 20, 30, 30, 30 };
		removeDuplicates(c);
		Utilities.printArray(c);
		
		int[] d = new int[] { 10 };
		removeDuplicates(d);
		Utilities.printArray(d);
		
		
	}
	
}
