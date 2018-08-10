package recursion;

public class RegexMatch {

	public static boolean regexMatch(String str, String pat) {
		if (pat.equals(".*") || (str.isEmpty() && pat.isEmpty()))
			return true;
		if (pat.isEmpty())
			return false;

		Token t = getNextToken(pat);
		// token is a single character match (such as a, or .)
		if (t.count == 1) {
			if (matches(str, t)) {
				return regexMatch(str.substring(1), pat.substring(1));
			} else {
				return false;
			}
			// token is one or more character match (such as a*, or .*)
		} else {
			if (matches(str, t)) {
				return regexMatch(str.substring(0), pat.substring(2))
						|| (!str.isEmpty() && regexMatch(str.substring(1), pat.substring(0)));
			} else {
				return false;
			}
		}

	}

	public static void main(String args[]) {

		System.out.println(regexMatch("aaaa", ".*"));
		System.out.println(regexMatch("aaab", ".*"));
		System.out.println(regexMatch("a", "a*"));
		System.out.println(regexMatch("aaab", ".*b"));
		System.out.println(regexMatch("", "b"));
		System.out.println(regexMatch("aaabc", ".*b"));
		System.out.println(regexMatch("", ".*b*.*"));
		System.out.println(regexMatch("aaabc", "aa.*abc"));

	}

	private static boolean matches(String str, Token ep) {
		if (str.isEmpty() && ep.count == -1)
			return true;
		if ((str.length() > 0) && (str.charAt(0) == ep.ch || ep.ch == '.'))
			return true;
		else
			return false;

	}

	private static Token getNextToken(String pat) {
		Token ep = new Token();
		ep.ch = pat.charAt(0);
		ep.count = 1;

		if (pat.length() >= 2 && pat.charAt(1) == '*')
			ep.count = -1;
		return ep;
	}

}

class Token {
	char ch;
	int count;

}
