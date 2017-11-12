package kata;

import junit.framework.TestCase;

public class KataExceptionTest extends TestCase {

	public KataExceptionTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public final void testKataException() {
		KataException excep = new KataException();
		assertNotNull(excep);
	}

	public final void testKataExceptionString() {
		try{
			throw new KataException("Kata");
		}
		catch(KataException e){
			assertEquals("Kata", e.getMessage());
		}
		
		
	}

	public final void testKataExceptionThrowable() {
		//wait
		//fail("Not yet implemented");
	}

}
