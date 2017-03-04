package arrays;

public class ProductofNumberexceptatIndex {

	public static int[] product(int []A){
		int []productL = new int[A.length];
		int []productR = new int[A.length];
		int []result = new int[A.length];
		productL[0]=1;
		productR[A.length-1]=1;
		for (int i = 1; i < A.length; i++) {
			productL[i] = productL[i-1]*A[i-1]; 
		}
		for (int i = A.length-2; i >= 0; i--) {
			productR[i] = productR[i+1]*A[i+1];
		}
	
		for (int i = 0; i < A.length; i++) {
			result[i] = productL[i]*productR[i];
		}
		return result;
	}
	
	public static void main(String []args){
		int []A = {2,5,6,3,4};
		int []result = product(A);
		for(int i: result){
			System.out.println(i);
		}
	}
}
