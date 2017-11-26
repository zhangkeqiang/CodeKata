package kata.prime;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.Prime;

public class AdvancedPrimeTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAdvancedPrime() {
		AdvancedPrime prime = new AdvancedPrime();
		assertNotNull(prime);
	}

	@Test
	public void testSearchMaxPrime100() {
		assertEquals(97, Prime.searchMaxPrime(100));
		assertEquals(97, AdvancedPrime.searchMaxPrime(100));
		
	}

	@Test
	public void testSearchMinPrime() {
		//fail("Not yet implemented");
	}

}
