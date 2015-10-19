package kata;

import junit.framework.TestCase;


public class InterestsTest extends TestCase {
	private InterestsCalculator calc;
	float fyear, fmoney, frate, fmonth;
	
	protected void setUp() throws Exception {
		super.setUp();
		fmoney = (float) 20000;
		frate = (float) 0.0375;
		calc = new InterestsCalculator();
	}
	
	public void testOneYearlincunzhenqu(){

		fyear = 1;
		assertEquals(calc.lincunzhenqu(fmoney,frate,fyear), fmoney*(1+frate));
	}
	
	public void testTwoYearlincunzhenqu(){
		fyear = 2;
		assertEquals(calc.lincunzhenqu(fmoney,frate,fyear), fmoney*(1+frate)+fmoney*(1+frate)*(1+frate));
	}
	
	public void test20Yearlincunzhenqu(){
		fyear = 20;
		assertEquals(calc.lincunzhenqu(fmoney,frate,fyear), (float) 602110.94);
	}
	
	public void test5Yearlincunzhenqu(){
		fyear = 5;
		assertEquals(calc.lincunzhenqu(fmoney,frate,fyear), (float) 111828.56);
	}
	
	public void test30Yearlincunzhenqu(){
		fyear = 30;
		fmoney = (float) 2450;
		frate = (float) 0.02;
		//assertEquals(calc.lincunzhenqu(fmoney,frate,fyear), (float) 111828.56);
		assertTrue(calc.lincunzhenqu(fmoney,frate,fyear) < (float) 111828.56);
	}
	
	public void test28Yearzhencunzhenqu(){
		fyear = 28;
		fmoney = (float) 101379;
		frate = (float) 0.025;
		assertEquals(calc.zhencunzhenqu(fmoney,frate,fyear), (float)202402.56);
	}
	
	public void test1Yearzhencunzhenqu(){
		fyear = 1;
		assertEquals(calc.zhencunzhenqu(fmoney,frate,fyear), fmoney*(1+frate));
	}
	
	public void test2Yearzhencunzhenqu(){
		fyear = 2;
		assertEquals(calc.zhencunzhenqu(fmoney,frate,fyear), fmoney*(1+frate)*(1+frate));
	}

	public void test10Yearzhencunzhenqu(){
		fyear = 10;
		assertEquals(calc.zhencunzhenqu(fmoney,frate,fyear), (float)28900.885);
	}
	
	public void testmortgagedenebenxi()
	{
		fmonth = 36;
		frate = (float) 0.014;
		fmoney = 100000;
		float fdenebenxi = calc.denebenxi(fmoney,frate,fmonth);
		assertTrue(fdenebenxi < (float) 3580 && fdenebenxi > (float) 3530);
		//assertEquals(fdenebenxi,0);
	}
	
	public void testYearandMonthInterests()
	{
		frate = (float) 0.014;
		assertTrue(calc.getYearInterestfromMonth(frate)>0.17);
	}
	
	public void testYearandMonthInterests2()
	{
		frate = (float) 0.015;
		assertTrue(calc.getYearInterestfromMonth(frate)>0.19);
	}
}
