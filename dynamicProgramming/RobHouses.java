package dynamicProgramming;

public class RobHouses {
	public static int rob(int []A){
		
		int prev_2=A[0],prev_1=Math.max(A[0], A[1]),i=2,current=prev_1;
		
		while(i<A.length){
			current=Math.max(A[i]+prev_2, prev_1);
			prev_2=prev_1;
			prev_1=current;
			i++;
		}
		
		return current;
	}
}
