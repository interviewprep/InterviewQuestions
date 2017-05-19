/**
 * Smallest substring with all the given characters
 * 
 */

package string;

import java.util.HashMap;

public class MinimumWindow {
	public static String minWindow(String text, String pattern) {

		if (pattern.length() > text.length() || pattern.isEmpty())
			return "";

		String result = "";

		// Store the occurrence(count) of characters of given pattern
		HashMap<Character, Integer> target = new HashMap<Character, Integer>();
		for (int i = 0; i < pattern.length(); i++) {
			target.put(pattern.charAt(i), target.getOrDefault(pattern.charAt(i), 0) + 1);
		}

		/*
		 * Start matching the characters of pattern with the characters of
		 * string i.e. increment count if a character matches
		 */

		// character counter for current window
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		int left = 0;
		int minLen = text.length();

		int count = 0; // the total of mapped characters

		for (int i = 0; i < text.length(); i++) {

			// count characters in the current window from left to i
			char c = text.charAt(i);
			if (target.containsKey(c)) {
				Integer countinWindow = map.getOrDefault(c, 0);
				if (countinWindow < target.get(c)) {
					count++;
				}
				map.put(c, map.getOrDefault(c, 0) + 1);
			}

			/*
			 * Check if all characters have been found (count == length of
			 * pattern ) in the current window. If window found, try to minimize
			 * it by removing extra characters from beginning of current window.
			 */

			if (count == pattern.length()) {
				char sc = text.charAt(left);
				while (!map.containsKey(sc) || map.get(sc) > target.get(sc)) {
					if (map.containsKey(sc) && map.get(sc) > target.get(sc))
						map.put(sc, map.get(sc) - 1);
					left++;
					sc = text.charAt(left);
				}

				if (i - left + 1 <= minLen) {
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
		System.out.println(minWindow("tesla", "tesla"));// tesla

	}

}
