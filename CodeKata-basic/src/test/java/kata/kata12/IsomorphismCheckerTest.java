package kata.kata12;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class IsomorphismCheckerTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public final void testab() {
		assertTrue(IsomorphismChecker.foo("a","b"));
	}

	@Test
	public final void testaabb() {
		assertTrue(IsomorphismChecker.foo("aa","bb"));
	}
	
	@Test
	public final void testlength() {
		assertFalse(IsomorphismChecker.foo("aaa","bb"));
	}
	
	@Test
	public final void testababab() {
		assertTrue(IsomorphismChecker.foo("abab","baba"));
		assertTrue(IsomorphismChecker.foo("abadddaaa1234","babcccbbb5678"));
		assertTrue(IsomorphismChecker.foo("abadddaaazzzzzz","babcccbbbeeeeee"));
	}
	
	@Test
	public final void testabababb() {
		assertFalse(IsomorphismChecker.foo("abaddddaaa","babccczbbb"));
	}

	
}
