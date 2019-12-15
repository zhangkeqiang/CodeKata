package kata;

import static org.junit.Assert.*;

import org.junit.Test;

public class CheckerTest {

	@Test
	public final void testCheckIsomorphic() {
		assertTrue(Checker.checkIsomorphic("a", "b"));
		assertTrue(Checker.checkIsomorphic("aa", "bb"));
		assertFalse(Checker.checkIsomorphic("aa", "bd"));
	}

}
