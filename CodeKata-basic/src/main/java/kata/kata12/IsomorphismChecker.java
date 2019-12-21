package kata.kata12;

public class IsomorphismChecker {
	public static boolean checkIsomorphic(String string1, String string2) {
		if (string1 == null || string2 == null || string1.length() != string2.length())
			return false;
		for (int i = 1; i < string1.length(); i++) {
			if (string1.indexOf(string1.charAt(i)) != string2.indexOf(string2.charAt(i)))
				return false;
		}
		return true;
	}

	private IsomorphismChecker() {
	}
}
