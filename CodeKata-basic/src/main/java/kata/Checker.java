package kata;

public class Checker {
	public static boolean checkIsomorphic(String s, String t) {
		for(int i=1; i<s.length();i++) {
			int si = s.indexOf(s.charAt(i));
			int ti= t.indexOf(t.charAt(i));
			if(si != ti)
				return false;
		}
		return true;
	}
}
