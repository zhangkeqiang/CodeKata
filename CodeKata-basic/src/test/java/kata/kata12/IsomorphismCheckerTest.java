package kata.kata12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IsomorphismCheckerTest {
	@Test
	public final void testab() {
		assertTrue(IsomorphismChecker.foo("a", "b"));
	}

	@Test
	public final void testaabb() {
		assertTrue(IsomorphismChecker.foo("aa", "bb"));
	}

	@Test
	public final void testlength() {
		assertFalse(IsomorphismChecker.foo("aaa", "bb"));
	}

	@Test
	public final void testababab() {
		assertTrue(IsomorphismChecker.foo("egg", "add"));
		assertFalse(IsomorphismChecker.foo("foo", "bar"));
	}

	@Test
	public final void testabababb() {
		assertFalse(IsomorphismChecker.foo("abaddddaaa", "babccczbbb"));
		assertFalse(IsomorphismChecker.foo("abadddaaad234", "babcccbbb5678"));
		assertFalse(IsomorphismChecker.foo("abadddaaazzzzzc", "babcccbbbeeeeee"));
		assertFalse(IsomorphismChecker.foo("asdfghjka", "bwertyuwb"));
	}

	@Test
	public final void testababab_more() {
		assertTrue(IsomorphismChecker.foo("abab", "baba"));
		assertTrue(IsomorphismChecker.foo("abadddaaa1234", "babcccbbb5678"));
		assertTrue(IsomorphismChecker.foo("abadddaaazzzzzz", "babcccbbbeeeeee"));
		assertTrue(IsomorphismChecker.foo("asdfghjka", "bwertyuib"));
	}

}
