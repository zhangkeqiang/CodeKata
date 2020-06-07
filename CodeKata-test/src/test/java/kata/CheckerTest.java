package kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckerTest {
	Checker checker = new Checker();
	@Test
	public final void testCheckIsomorphic() {
		assertTrue(checker.checkIsomorphic("a", "b"));
		assertTrue(checker.checkIsomorphic("aa", "bb"));
		assertFalse(checker.checkIsomorphic("aa", "bd"));
	}

}
