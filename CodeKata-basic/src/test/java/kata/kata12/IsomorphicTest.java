package kata.kata12;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

public class IsomorphicTest {
	Isomorphic isomorphic = new Isomorphic();
	Logger logger = LogManager.getLogger();

	@Test
	public final void test() {
		assertNotNull(isomorphic);
	}

	@Test
	public void shownormalizedString() {
		int[] normalizedString = isomorphic.normalized("abcdaabcd");
		for (int i = 0; i < normalizedString.length; i++) {
			logger.info(normalizedString[i]);
		}
	}

	@Test
	public void should_be_false_when_length_is_different() {
		assertFalse(isomorphic.check("a", "bc"));
	}

	@Test
	public void should_be_true_when_equals() {
		assertTrue(isomorphic.check("a", "a"));
	}

	@Test
	public void should_be_true_when_length_is_same_and_no_duplication_char() {
		assertTrue(isomorphic.check("a", "b"));
		assertTrue(isomorphic.check("ab", "dc"));
	}

	@Test
	public void should_be_false_when_length_is_same_but_one_has_duplicated_char() {
		assertFalse(isomorphic.check("ab", "dd"));
	}

	@Test
	public void acceptance_tests() {
		assertTrue(isomorphic.check("egg", "add"));
		assertFalse(isomorphic.check("foo", "bar"));
		assertTrue(isomorphic.check("addanegg", "teetabdd"));
		assertFalse(isomorphic.check("tddisbdd", "bddnttdd"));
	}

}
