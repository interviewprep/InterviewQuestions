package string;

public class RotateString {
	static public String rotateString(String input, int times) {
		StringBuilder sb = new StringBuilder();
		int len = input.length();

		for (int i = 0; i < len; i++) {
			if (i < times)
				sb.append(input.charAt(i));
			else
				sb.insert(i - times, input.charAt(i));
		}

		return sb.toString();
	}
	public static void main(String []args){
		System.out.println(rotateString("abcde", 3));
	}
}
