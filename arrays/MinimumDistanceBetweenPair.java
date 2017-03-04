package arrays;

public class MinimumDistanceBetweenPair {

	public static int minDist(int []A, int first , int second){
		
		if(A==null) return -1;
		
		int indexF=-1,indexS=-1,dist=Integer.MAX_VALUE;
		
		for (int i = 0; i < A.length; i++) {
			if(A[i]==first){
				indexF=i;
				if(indexS!=-1){
					dist = Math.min(dist, indexF-indexS);
				}
			}
			if(A[i] == second){
				indexS=i;
				if(indexF!=-1){
					dist = Math.min(dist, indexS-indexF);
				}
			}
		}
		
		return dist;
	}
	
	public static void main(String []args){
		int []A = {1,3,6,2,7,9,8,2};
		System.out.println(minDist(A,3,9));
	}
}
