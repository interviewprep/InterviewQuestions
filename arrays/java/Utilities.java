package arrays.java;

public class Utilities<T> {
	public static <T> void swap(T[] A, int i, int j) {
		T temp = A[i];
		A[i] = A[j];
		A[j] = temp;
	}

	public static <T> void printArray(T[] A) {
		for (T t : A) {
			System.out.print(t + " ");
		}
		System.out.println();
	}
	
	public static  void printArray(int[] A) {
		for ( int t : A) {
			System.out.print(t + " ");
		}
		System.out.println();
	}

}
