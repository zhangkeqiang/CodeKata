package kata.clock;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;

public class ClockTest {

	@Test
	public void testLundunClock_is_1oclock_when_Beijing_is_9() {
		Clock lundunClock = new Clock(0);
		BasicClock beijingClock = new BasicClock(8);
		beijingClock.setTime("9:00:00");
		String expected = "01:00:00";
		String actual = lundunClock.getTime();
		Assert.assertEquals(expected,actual );
	}
	
	
   @Test
    public void testLundunClock_is_1oclock_nozero_when_Beijing_is_9() {
        Clock lundunClock = new Clock(0);
        lundunClock.setDisplayFormat(Clock.H12NOZERO);
        BasicClock beijingClock = new BasicClock(8);
        beijingClock.setTime("9:00:00");
        String expected = "1:00:00";
        String actual = lundunClock.getTime();
        Assert.assertEquals(expected,actual );
    }
	
	@Test
	public void testLundunClock_is_2oclock_when_Beijing_is_10() {
		Clock lundunClock = new Clock(0);
		BasicClock beijingClock = new BasicClock(8);
		beijingClock.setTime("10:00:00");
		String expected = "02:00:00";
		String actual = lundunClock.getTime();
		Assert.assertEquals(expected,actual );
	}

	@Test
	public void testLundunClock_is_6oclock_when_Beijing_is_2() {
		Clock lundunClock = new Clock(0);
		BasicClock beijingClock = new BasicClock(8);
		beijingClock.setTime("02:00:00");
		String expected = "06:00:00";
		String actual = lundunClock.getTime();
		Assert.assertEquals(expected,actual );
	}
	
	@Test
	public void testLundunClock_is_12oclock_when_Beijing_is_8() {
		Clock lundunClock = new Clock(0);
		BasicClock beijingClock = new BasicClock(8);
		beijingClock.setTime("08:22:22");
		String expected = "12:22:22";
		String actual = lundunClock.getTime();
		Assert.assertEquals(expected,actual );
	}
	
	@Test
	public void testNewYorkClock_is_7oclock_when_Beijing_is_8() {
		Clock newyorkClock = new Clock(-5);
		BasicClock beijingClock = new BasicClock(8);
		beijingClock.setTime("08:22:22");
		String expected = "07:22:22";
		String actual = newyorkClock.getTime();
		Assert.assertEquals(expected,actual );
	}
	
   @Test
    public void testNewYorkClock_is_5oclock_when_Beijing_is_18() {
        Clock newyorkClock = new Clock(-5);
        BasicClock beijingClock = new BasicClock(8);
        beijingClock.setTime("18:22:22");
        String expected = "05:22:22";
        String actual = newyorkClock.getTime();
        Assert.assertEquals(expected,actual );
    }
	
   @Test
   public void testNewYorkClock_interactive_with_Beijing() {
       Clock newyorkClock = new Clock(-5);
       newyorkClock.setDisplayFormat(Clock.H24NOZERO);
       BasicClock beijingClock = new BasicClock(8);
       beijingClock.setTime("8:22:22");
       String expected = "19:22:22";
       String actual = newyorkClock.getTime();
       Assert.assertEquals(expected,actual );
       
       beijingClock.setTime("14:22:22");
       expected = "1:22:22";
       actual = newyorkClock.getTime();
       Assert.assertEquals(expected,actual );
       newyorkClock.setDisplayFormat(Clock.H24ZERO);
       expected = "01:22:22";
       actual = newyorkClock.getTime();
       Assert.assertEquals(expected,actual );
   }
   
   
}
