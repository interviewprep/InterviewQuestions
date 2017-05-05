package string;

import java.util.HashMap;

/**
 * Smallest substring with all the given characters
 * 
 *
 */
public class MinimumWindow {
	public static String minWindow(String text, String pattern) {
		/**
		 * check if length of string is less than the length of given pattern,
		 * if yes then "no such window can exist ".
		 */
		if (pattern.length() > text.length())
			return "no such window can exist";
		String result = "";

		// character counter for t
		/**
		 * Store the occurrence(count) of characters of given pattern
		 */
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			char c = pattern.charAt(i);
			if (target.containsKey(c)) {
				target.put(c, target.get(c) + 1);
			} else {
				target.put(c, 1);
			}
		}
		/**
		 * Start matching the characters of pattern with the characters of
		 * string i.e. increment count if a character matches
		 */
		// character counter for s
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int minLen = text.length() + 1;

		int count = 0; // the total of mapped characters

		for (int i = 0; i < text.length(); i++) {
			char c = text.charAt(i);

			if (target.containsKey(c)) {
				if (map.containsKey(c)) {
					if (map.get(c) < target.get(c)) {
						count++;
					}
					map.put(c, map.get(c) + 1);
				} else {
					map.put(c, 1);
					count++;
				}
			}
			/**
			 * Check if (count == length of pattern ) this means a window is
			 * found
			 */
			if (count == pattern.length()) {
				char sc = text.charAt(left);
				while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
					if (map.containsKey(sc) && map.get(sc) > target.get(sc))
						map.put(sc, map.get(sc) - 1);
					left++;
					sc = text.charAt(left);
				}
				/**
				 * If window found, try to minimize it by removing extra
				 * characters from beginning of current window.
				 */
				if (i - left + 1 < minLen) {
					result = text.substring(left, i + 1);
					// update MinLength
					minLen = i - left + 1;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		System.out.println(minWindow("this is a test string", "tist"));// t stri
		System.out.println(minWindow("axyaedefa", "ea"));// ae
		System.out.println(minWindow("geeksforgeeks", "ork"));// ksfor

	}

}
