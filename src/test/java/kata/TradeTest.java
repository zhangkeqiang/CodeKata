package kata;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class TradeTest extends TestCase {
	private Trade trade;
	
	private List<Integer> list(int... ints) {
	    List<Integer> list = new ArrayList<Integer>();
	    for (int i : ints){
	      list.add(i);
	    }
	    return list;
	  }
	
	protected void setUp() throws Exception {
		super.setUp();
		trade = new Trade();
	}

	public void testgetChange100(){
		assertEquals(list(), trade.getChange(100));
	}
	
	public void testgetChange50(){
		assertEquals(list(50), trade.getChange(50));
	}
	
	public void testgetChange40(){
		assertEquals(list(50,10),trade.getChange(40));
	}
	
	public void testgetChange35(){
		assertEquals(list(50,10,5),trade.getChange(35));
	}
	
	public void testgetChange34(){
		assertEquals(list(50,10,5,1),trade.getChange(34));
	}
	
	public void testgetChange96(){
		assertEquals(list(1,1,1,1),trade.getChange(96));
	}
	
	public void testgetChange1(){
		assertEquals(list(50,10,10,10,10,5,1,1,1,1),trade.getChange(1));
	}
	
	public void testgetChange99(){
		assertEquals(list(1),trade.getChange(99));
	}
	
	public void testgetChange199(){
		assertEquals(list(1),trade.getChange(199));
	}
	
	public void testgetChange10001(){
		assertEquals(list(50,10,10,10,10,5,1,1,1,1),trade.getChange(10001));
	}
	
	/**/
	
}
