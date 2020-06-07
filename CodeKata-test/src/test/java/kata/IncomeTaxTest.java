package kata;

import junit.framework.TestCase;

public class IncomeTaxTest extends TestCase {
	private IncomeTax tax;
	protected void setUp() throws Exception {
		super.setUp();
		tax = new IncomeTax();
	}
	
	public void test100(){
		assertEquals(0.0, tax.calculate(100));
	}
	
	public void test3500(){
		assertEquals(0.0, tax.calculate(3500));
	}
	
	public void test4000(){
		assertEquals(15.0, tax.calculate(4000));
	}
	
	public void test6000(){
		assertEquals(145.0, tax.calculate(6000));
	}
	
	public void test10000(){
		assertEquals(745.0, tax.calculate(10000));
	}
	
	public void test20000(){
		assertEquals(3120.0, tax.calculate(20000));
	}
	
	public void test50000(){
		assertEquals(18120.0, tax.calculate(50000));
	}
	
/**/
}
