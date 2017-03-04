package arrays;

public class SubArrayofSize3 {
	public static int largestSum(int []A){
		if(A==null||A.length<3) return 0;
		int curSum=A[0]+A[1]+A[2],maxSum=curSum;
		for(int start=0,end=3;end<A.length;start++,end++){
			curSum=curSum-A[start]+A[end];
			if(curSum>maxSum) maxSum=curSum;
		}
		return maxSum;
	}
	public static void main(String []args){
		int []A={-1,2,3,4,-5,6,7,1};
		System.out.println(largestSum(A));
	}

}
