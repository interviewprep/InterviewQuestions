package recursion;

import java.util.HashSet;
import java.util.Arrays;


public class SplitWords {
	
	public static boolean splitWords(String word, HashSet<String> dictionary) {
		if (word.isEmpty() || dictionary.contains(word))
			return true;
		for (int i =1; i< word.length(); i++) {
			if (splitWords(word.substring(0, i), dictionary) && splitWords(word.substring(i, word.length()), dictionary)) {
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		
		System.out.println(splitWords("abc", new HashSet<String>(Arrays.asList("a", "b", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("a", "b", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "bc"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "c"))));
		System.out.println(splitWords("abbc", new HashSet<String>(Arrays.asList("abb", "ab", "bbc"))));
	}

}
