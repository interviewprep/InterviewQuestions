package arrays.java;
/*
 * Count the number of sub arrays of a given array that has 3 as the maximum number (in that sub array)
 * Given the array [3,2,6,1,3], the following sub arrays have 3 as the max number
 * [3], [3, 2], [ 1, 3], [3]
 */

public class SubArrayWithMaximum {
public static int countSubArrays(int array[]) {
	int i =0, j=0;
	int j_start = 0;
	int count3 = 0;
	int  subArrays = 0;
	while (i <= j && j < array.length) {
		if (array[j] == 3) { 
			count3++;
			j++;
		}
		else if (array[j] < 3) {
			j++;
		}
		else {   // j > 3
			while (i < j && count3 > 0) {
				
				if (array[i] == 3) {
					count3--;
					subArrays = subArrays + (i - j_start) + (j - i);
				}
				i++;
			}
			i = j+1;
			j_start = i;
			j = i; 
			count3 = 0;
			continue;
		}
	}
	if (i <=j && j >= array.length) {
		while (i < array.length && count3 > 0) {
			
			if (array[i] == 3) {
				count3--;
				subArrays = subArrays + (i - j_start) + (j - i);
			}
			i++;
		}
	}
	return subArrays;
}
public static void main (String args[]) {
	int array[]= {3,2,6,1, 2, 3, 6};
	System.out.println(countSubArrays(array));
}
}
