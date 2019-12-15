package kata.kata12;

public class IsomorphismChecker {
	public static boolean checkIsomorphic(String s, String t) {
		if (s == null || t == null || s.length() != t.length())
			return false;
		for (int i = 1; i < s.length(); i++) {
			if (s.indexOf(s.charAt(i)) != t.indexOf(t.charAt(i)))
				return false;
		}
		return true;
	}

	private IsomorphismChecker() {
	}
}
