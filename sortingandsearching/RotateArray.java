package sortingandsearching;

public class RotateArray {
	
	  private static void rotateArray(int [][] A) {
		    for (int i = 0; i < (A.length / 2); ++i) {
		      for (int j = i; j < A.length - i - 1; ++j) {
		        // Perform a 4-way exchange.
		        int temp = A[i][j];
		        A[i][j] = A[A.length - 1 - j][i];
		        A[A.length - 1 - j][i] =  A[A.length - 1 - i][A.length - 1 - j];
		        A[A.length - 1 - i][A.length - 1 - j] = A[j][A.length - 1 - i];
		        A[j][A.length - 1 - i] =  temp;
		      }
		    }
		  }

	  public static void main( String []args) {
		  int [][] A = {
				  {1,2,3,},
				  {4,5,6},
				  {7,8,9,},
		  };
		  rotateArray(A);
		  for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A.length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}
		  
	  }
}
