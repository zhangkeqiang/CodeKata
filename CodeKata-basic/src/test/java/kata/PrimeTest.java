package kata;

import junit.framework.TestCase;

public class PrimeTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void test2(){
		assertEquals(2, Prime.searchMaxPrime(2));
	}
	
	public void test4(){
		assertEquals(3, Prime.searchMaxPrime(4));
	}
	
	public void test6(){
		assertEquals(5, Prime.searchMaxPrime(6));
	}
	
	public void test9(){
		assertEquals(7, Prime.searchMaxPrime(9));
	}
	
	public void test10(){
		assertEquals(7, Prime.searchMaxPrime(10));
	}
	
	public void test18(){
		assertEquals(17, Prime.searchMaxPrime(18));
	}
	
	public void test28(){
		assertEquals(23, Prime.searchMaxPrime(28));
	}
	
	public void test100(){
		assertEquals(97, Prime.searchMaxPrime(100));
	}
	
	public void test1000000(){
		assertTrue("1000000",Prime.searchMaxPrime(1000000) == 999983);
	}
	
	public void test0(){
		try{
			assertTrue(Prime.searchMaxPrime(0) != 0);
		}catch(Exception e)
		{
			assertTrue(e.getMessage().startsWith("Prime"));
		}
	}
	
	public void testminus100(){
		assertEquals("-100",-1, Prime.searchMaxPrime(-100));
	}
	
	public void test1(){
		assertEquals(1, Prime.searchMaxPrime(1));
	}
	
	public void testmin100(){
		assertEquals(">100 min prime",101, Prime.searchMinPrime(100));
	}
	
	public void testmin99(){
		assertEquals(">99 min prime",101, Prime.searchMinPrime(99));
	}
}
