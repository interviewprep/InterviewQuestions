package strings;

/*
 * Rotate an array of strings by k times.
 */

public class RotateString {
	static public char[] rotateString(char[] input, int times) {
		
		 times = times%input.length;
		 
		 reverseArray(input, 0, input.length - 1);
		 reverseArray(input, 0, times - 1);
		 reverseArray(input, times, input.length - 1);
		 return input;
	}
	
	public static void main(String []args){
		char[] charArray = {'a', 'b', 'c', 'd', 'e'};
		System.out.println(rotateString(charArray, 6));
	}
	
	private static void reverseArray(char array[], int start, int end) {
		while(start <= end) {
			char temp = array[end];
			array[end] = array[start];
			array[start] = temp;
			start++; end--;
		}
	}
}
