package kata.kata12;

import static org.junit.Assert.*;

import org.junit.Test;

public class IsomorphismCheckerTest {
	@Test
	public final void testnulla() {
		assertFalse(IsomorphismChecker.checkIsomorphic(null, "b"));
	}
	
	@Test
	public final void testnullb() {
		assertFalse(IsomorphismChecker.checkIsomorphic("a", null));
	}
	@Test
	public final void testab() {
		assertTrue(IsomorphismChecker.checkIsomorphic("a", "b"));
	}

	@Test
	public final void testaabb() {
		assertTrue(IsomorphismChecker.checkIsomorphic("aa", "bb"));
	}

	@Test
	public final void testlength() {
		assertFalse(IsomorphismChecker.checkIsomorphic("aaa", "bb"));
	}

	@Test
	public final void testababab() {
		assertTrue(IsomorphismChecker.checkIsomorphic("egg", "add"));
		assertFalse(IsomorphismChecker.checkIsomorphic("foo", "bar"));
	}

	@Test
	public final void testabababb() {
		assertFalse(IsomorphismChecker.checkIsomorphic("abaddddaaa", "babccczbbb"));
		assertFalse(IsomorphismChecker.checkIsomorphic("abadddaaad234", "babcccbbb5678"));
		assertFalse(IsomorphismChecker.checkIsomorphic("abadddaaazzzzzc", "babcccbbbeeeeee"));
		assertFalse(IsomorphismChecker.checkIsomorphic("asdfghjka", "bwertyuwb"));
	}

	@Test
	public final void testMoreTrue() {
		assertTrue(IsomorphismChecker.checkIsomorphic("abab", "baba"));
		assertTrue(IsomorphismChecker.checkIsomorphic("abadddaaa1234", "babcccbbb5678"));
		assertTrue(IsomorphismChecker.checkIsomorphic("abadddaaazzzzzz", "babcccbbbeeeeee"));
		assertTrue(IsomorphismChecker.checkIsomorphic("asdfghjka", "bwertyuib"));
	}

}
