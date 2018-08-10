package recursion;

public class DecodeNumericStringWithWildCard {
	
	public static int decode(String str) {
		if (str.isEmpty())
			return 1;
		else if (str.length() == 1) {
			return getMultiplier(str);
		}
		int multiplier = getMultiplier(str.substring(0,1));
	    
		
		int c1 = decode(str.substring(1)) * multiplier;
		int c2 = 0;
		
		if (str.length() > 1) {
			c2 = decode(str.substring(2)) * getMultiplier(str.substring(0, 2));
		}	
		return c1 + c2;
	}
	public static int getMultiplier(String str) {
		if (str.equals("*"))
			return 9;
		else if (str.equals("**"))
			return 26;
		else if (str.startsWith("0"))
			return 0;
		else if (str.startsWith("*")){
			int i = Integer.parseInt(str.substring(1,2));
			if (i <=6) return 2;
			else return 1; 
		} else if (str.endsWith("*")) {
			int i = Integer.parseInt(str.substring(0,1));
			if (i == 1) 
				return 10;
			else if (i == 2) 
				return 7;
			else 
				return 0;
		}
		int num =  Integer.parseInt(str);
		if (num <= 26)
			return 1;
		else 
			return 0;
	}
	private static  boolean isValid(String str) {
		Integer i = Integer.parseInt(str);
		if (i <= 26)
			return true;
		return false;
	}
	
	public static void main(String args[]) {
		System.out.println(" 1*: " + decode("1*"));
		System.out.println(" *1: " + decode("*1"));
		System.out.println(" 1*1: " + decode("1*1"));
		System.out.println(" 2*1: " + decode("2*1"));
		System.out.println(" 129: " + decode("129"));
	}
	

}
