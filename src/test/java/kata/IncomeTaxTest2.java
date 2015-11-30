package kata;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;

public class IncomeTaxTest2 {
	private IncomeTax tax;
	private Object parameters[][] = { 
			{ 100, 0 }, 
			{ 3500, 0 }, 
			{ 4000, 15 }, 
			{ 6000, 145 }, 
			{ 10000, 745 }, };

	@Before
	public void setUp() throws Exception {
		tax = new IncomeTax();
	}

	@Test
	public void testTax() {
		for (int i = 0; i < 5; i++) {
			int income = Integer.parseInt(parameters[i][0].toString());
			double taxresult = Double.parseDouble(parameters[i][1].toString());
			assertTrue(taxresult == tax.calculate(income));
		}
	}

}
