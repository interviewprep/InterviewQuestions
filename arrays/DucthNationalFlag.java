package arrays;

public class DucthNationalFlag {
	public static void reArrange(int []A){
		int first=0,second=0,third=A.length-1;
		while(second<=third){
			if(A[second]<0){
				Utilities.swap(A,first++,second++);
			}
			else if(A[second]>0){
				Utilities.swap(A,second,third--);
			}
			else {
				second++;
			}
		}
	}
	
	public static void main(String []args){
		int []A={0,1,5,-6,-2,7,8,-11,0};
		reArrange(A);
		Utilities.printArray(A);
		
	}

}
