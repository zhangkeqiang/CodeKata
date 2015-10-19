package kata;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

public class ChangeTest extends TestCase {
	Change change = new Change();
private List<Integer> list(int... ints) {
	List<Integer> list = new ArrayList<Integer>();
	    for (int i : ints){
	      list.add(i);
	    }
	    return list;
	}
	public void test100(){		
		assertEquals(change.getChange(100), list());
	}
	
	public void test99(){		
		assertEquals(change.getChange(99), list(1));
	}
	
	public void test50(){
		assertEquals(change.getChange(50), list(50));
	}
	
	public void test49(){
		assertEquals(change.getChange(49), list(50,1));
	}
	
	public void test1(){
		assertEquals(change.getChange(1), list(50,10,10,10,10,5,1,1,1,1));
	}
	
	
}
