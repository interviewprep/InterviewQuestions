/*
 * Given a sorted array of Integers, can you find if there are two numbers that add up to a given target?
 */

package arrays;
import java.util.Arrays;


public class TwoSum {
	public static boolean istwonumberspresent(int []A, int target){
		if(A==null) return false;
		int start=0,end =A.length-1;
		while(start<end){
			int currentSum=A[start]+A[end];
			if(currentSum==target) return true;
			else if(currentSum<target) start++;
			else end--;
		}
		return false;
	}
	
	public static boolean threesum(int []A, int target){
		if(A==null) return false;
		for(int i=0;i<A.length-3;i++){
			int j=i+1,k=A.length-1,sum= target-A[i];
			while(j<k)
			{
				if(A[j]+A[k]<sum) j++;
				else if(A[j]+A[k]>sum) k--;
				else return true;
			}
		}
		return false;
	}

	public static boolean threesum2(int []A,int target){
		if(A==null) return false;
		for (int i = 0; i < A.length; i++) {
			if(find(A,target-2*A[i])) return true;
		}
		for(int i=0;i<A.length-3;i++){
			int j=i+1,k=A.length-1,sum= target-A[i];
			while(j<k)
			{
				if(A[j]+A[k]<sum) j++;
				else if(A[j]+A[k]>sum) k--;
				else return true;
			}
		}	
		
		return false;
	}
	
	public static boolean find(int []A, int target){
		int lo=0,hi=A.length-1;
		while(lo<=hi){
			int mid=lo+(hi-lo)/2;
			if(A[mid]==target) return true;
			else if(A[mid]<target) lo=mid+1;
			else hi=mid-1;
		}
		
		return false;
	}
	
	public static int closest(int []A, int target){
		int start=0,end=A.length-1,closest=Integer.MAX_VALUE;
		while(start<end){
			int curSum=A[start]+A[end];
			if(Math.abs(target-curSum)<closest){
				closest=Math.abs(target-curSum);
				if(closest==0) return closest;
			}
			if(curSum<target)start++;
			else end--;
		}
		return closest;
	}

	
	public static void main(String []args){
		int []a = {5,6,7,12,13};
		int []b={1,7,8};
		System.out.println(threesum(a,20));
		System.out.println(threesum2(a,20));
		System.out.println(threesum(b,11));
		System.out.println(threesum2(b,15));
		System.out.println(threesum2(b,24));
		System.out.println(threesum2(b,14));
	}

}
