package kata.kata12;

public class IsomorphismChecker {
	public static boolean checkIsomorphic(String stringA, String stringB) {
		if (stringA == null || stringB == null)
			return false;
		if (stringA.length() != stringB.length())
			return false;
		for (int i = 1; i < stringA.length(); i++) {
			if (stringA.indexOf(stringA.charAt(i)) != stringB.indexOf(stringB.charAt(i)))
				return false;
		}
		return true;
	}

	private IsomorphismChecker() {
	}
}
