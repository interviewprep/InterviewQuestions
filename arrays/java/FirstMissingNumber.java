package arrays;

public class FirstMissingNumber {
	class Solution {
	    public int firstMissingPositive(int[] nums) {
	        int start=0;
	        if (nums.length==0)
	            return 1;
	        boolean numLengthpresent = false;
	        while(start< nums.length) {
	            if (nums[start]>nums.length || nums[start]<=0 || nums[start]==start) {
	                start++;
	                continue;
	            }
	               
	            if (nums[start]==nums.length) {
	                start++;
	                numLengthpresent = true;
	                continue;
	            }
	            
	                while(nums[start] !=start && nums[start]>0 && nums[start]<nums.length) {
	                int next = nums[start];
	                int temp = nums[next];
	                if (nums[start]==nums[next])
	                    break;
	                nums[next] = nums[start];    
	                nums[start] = temp;
	                    
	                }
	                if (nums[start]==nums.length) {
	         
	                numLengthpresent = true;

	              }
	            start++;
	            
	            
	        }
	        
	        for (int i=1;i<nums.length;i++) {
	            if (nums[i] !=i)
	                return i;
	        }
	        System.out.println(numLengthpresent);
	        if (!numLengthpresent)
	            return nums.length;
	        return nums.length+1;
	        
	    }
	}

}
