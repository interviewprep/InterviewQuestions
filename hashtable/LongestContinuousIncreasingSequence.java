package hashtable;

import java.util.HashSet;
import java.util.Set;

public class LongestContinuousIncreasingSequence {

	public static int longestSequence(int nums[]) {
		Set<Integer> hashset = new HashSet<Integer>();
		for (int num : nums) {
			hashset.add(num);
		}
		int maxLen = 0;
		for (int num: nums) {
		  int len = maxSequence(num, hashset);
		  if (len > maxLen)
			  maxLen = len;
		}
		return maxLen;
	}
	
	private static int maxSequence(int num, Set<Integer> set) {
		int count = 0;
		int temp = num;
		while(temp >= num) { // keep going as long as there is no over/under flow
			if (set.contains(temp)) {
				count++;
				set.remove(temp);
				temp++;
			}
			else
				break;
		}
		temp = num-1;
		while(temp < num) { // keep going as long as there is no over/under flow
			if (set.contains(temp)) {
				count++;
				set.remove(temp);
				temp--;
			}
			else
				break;
		}
	
		return count;
	}
	public static void main(String args[]) {
		int num[] = {5,6, 9,8,10,11,12};
		System.out.println(longestSequence(num));
		int num2[]= {Integer.MAX_VALUE, Integer.MIN_VALUE, 1};
		System.out.println(longestSequence(num2));
	}
	

}
