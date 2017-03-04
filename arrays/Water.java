package arrays;

public class Water {
	
	public static int max(int[] A){
	    int start=0;
	    int end=A.length-1;
	    int max=0;
	    int leftmax=0;
	    int rightmax=0;
	    while(start<=end){
	        leftmax=Math.max(leftmax,A[start]);
	        rightmax=Math.max(rightmax,A[end]);
	        if(leftmax<rightmax){
	            max+=(leftmax-A[start]);      
	            start++;
	        }
	        else{
	            max+=(rightmax-A[end]);
	            end--;
	        }
	    }
	    return max;
	}

}
