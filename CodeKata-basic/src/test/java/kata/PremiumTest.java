package kata;

import junit.framework.TestCase;

public class PremiumTest extends TestCase {
	
	private int[] age  =      { 20,   30,  40,   2,  -3,   8,  25, 55 };
	private char[] gender =   {'M',  'F', 'M', 'F', 'f', 'D', 'M', 'F'};
	private char[] marriage = {'Y',  'N', 'Y', 'N', 'n', 'N', 'D', 'Y'};
	private int[]  children = {  1,    2,   0,   2,   3,   8,   2,  -1};  
	private double[] rate =   {0.6,  0.6, 0.6, 0.4, 0.6, 0.4, 0.4, 0.4}; 

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testcalculatePremiumRate() throws Exception {
		Premium premium = new Premium();
		for(int i = 0; i < age.length; i++)
		{
			try{
				assertEquals(rate[i], premium.calculatePremiumRate(age[i], gender[i], marriage[i], children[i]));
			}catch(Exception e)
			{
				assertTrue(e.getMessage().startsWith("Premium"));
			}
			
		}
		
	}
	
	public void testAgebelowZero() throws Exception {
		Premium premium = new Premium();
		try{
			assertEquals(0.0, premium.calculatePremiumRate(-1, 'M', 'Y', 1));
		}catch(Exception e)
		{
			assertEquals("Premium:age can't be below zero.", e.getMessage());
		}
		
	}
	

}
