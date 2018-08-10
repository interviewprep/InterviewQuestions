/*
 * Multiply two integers represented as char arrays. Example, your input would be two char
 * arrays {9}, {1, 1, 1}. The result should be another char array {9, 9, 9}.
 */

package strings;

public class MultiplyLargeIntegers {

	public static char[] multiply(char[] num1, char num2[]) {
		char[] longer;
		char[] smaller;

		// for convenience, store the arrays as longer and smaller
		if (num1.length > num2.length) {
			longer = num1;
			smaller = num2;
		} else {
			longer = num2;
			smaller = num1;
		}

		// Calculate the size of the result array. This is based on the
		// intuition that we pick one number from the smaller array and
		// multiply it with all the numbers of the larger array. We then repeat
		// the process for the next number from the smaller array, but the
		// result is shifted by 1.
		
		// calculate size of result array. We end up over-calculating it by 1, but that's okay.
		char result[] = new char[(longer.length + 1) + (smaller.length - 1) + 1];
		char temp[] = new char[result.length];
		for (int i = 0; i < temp.length; i++)
			temp[i] = '0';

		//
		int k = temp.length - 1;
		for (int i = smaller.length - 1; i >= 0; i--) {
			int prod = 0;
			int carry = 0;
			int index = k--;
			for (int j = longer.length - 1; j >= 0; j--) {
				System.out.println("Multiplying " + i + "and " + j);
				prod = Integer.parseInt("" + longer[j]) * Integer.parseInt("" + smaller[i]) + carry;
				int sum = prod % 10;
				carry = prod / 10;

				add(temp, index--, sum);

			}
			add(temp, index, carry);
		}

		return result;
	}

	private static void add(char[] array, int index, int num) {
		System.out.println("adding " + num + "at index " + index);
		int carry = num;
		int j = index;
		while (j >= 0) {
			int sum = Integer.parseInt("" + array[j]) + carry;
			array[j] = Character.forDigit(sum % 10, 10);
			carry = sum / 10;
			if (carry == 0)
				break;
			j--;
		}
		System.out.println("The resultant array is " + new String(array));
	}

	public static void main(String args[]) {
		char array1[] = { '1', '0' };
		char array2[] = { '1', '0' };
		char result[] = multiply(array1, array2);
		System.out.println(new String(result));

	}

}
