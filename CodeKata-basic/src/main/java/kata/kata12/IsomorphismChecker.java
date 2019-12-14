package kata.kata12;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class IsomorphismChecker {
	
	static protected Logger log = LogManager.getLogger();
	
	public static boolean foo(String S, String T) {
		if(S == null | T== null) return false;
		if(S.length() != T.length()) return false;
		StringBuffer SS = new StringBuffer("A");
		StringBuffer TT = new StringBuffer("A");
		int j = (int)'A';
		for(int i=1;i<S.length();i++) {
			int sj = S.indexOf(S.charAt(i));
			SS.append((char)(j+sj));
			int tj = T.indexOf(T.charAt(i));
			TT.append((char)(j+tj));
			log.debug(SS);
			log.debug(TT);
			if(!SS.toString().equals(TT.toString()))
				return false;
		}
		return true;
	}

}
