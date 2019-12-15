package kata;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Checker {
	protected static Logger log = LogManager.getLogger();

	public static boolean checkIsomorphic(String s, String t) {
		if (s == null || t == null)
			return false;
		if (s.length() != t.length())
			return false;
		if (s.length() == 1)
			return true;
		StringBuffer sf = new StringBuffer("A");
		StringBuffer tf = new StringBuffer("A");
		for (int i = 1; i < s.length(); i++) {
			sf.append((char) ('A' + s.indexOf(s.charAt(i))));
			tf.append((char) ('A' + t.indexOf(t.charAt(i))));
			log.debug(sf.toString());
			log.debug(tf.toString());
			if (!sf.toString().equals(tf.toString()))
				return false;
		}
		return true;

	}
}
