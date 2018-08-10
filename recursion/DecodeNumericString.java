package recursion;

public class DecodeNumericString {
	
	public static int decode(String str) {
		if (str.isEmpty())
			return 1;
		else if (str.length() == 1 ) {
         if (isValid(str)) 
        	 	return 1;
         else
        	 	return 0;
		}
		
		int c1=0, c2 = 0;
		if (isValid(str.substring(0,1))) {
		    c1 = decode(str.substring(1));
		}
		if (str.length() > 1 && isValid(str.substring(0, 2))) {
			c2 = decode(str.substring(2));
		}	
		return c1 + c2;
	}
	private static  boolean isValid(String str) {
		if (str.startsWith("0"))
			return false;
		Integer i = Integer.parseInt(str);
		if (i <= 26)
			return true;
		return false;
	}
	public static void main(String args[]) {
		System.out.println(" 123: " + decode("123"));
		System.out.println(" 129: " + decode("129"));
		System.out.println(" 123: " + decode("123"));
		System.out.println(" 20: " + decode("20"));
		System.out.println(" 02: " + decode("02"));
		System.out.println(" 201: " + decode("201"));
	}
	

}
