package kata;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import static kata.PrimeFactors.generate;
import static kata.PrimeFactors.calcMinCommonMultiple;

public class PrimeFatortsTest extends TestCase {
	  private List<Integer> list(int... ints) {
		    List<Integer> list = new ArrayList<Integer>();
		    for (int i : ints){
		      list.add(i);
		    }
		    return list;
		  }
	  
	  public void testOne() throws Exception {
		    assertEquals(list(),generate(1));
	  }
	  
	  public void testTwo() throws Exception {
		    assertEquals(list(2),generate(2));
	  }
	  
	  public void testThree() throws Exception {
		    assertEquals(list(3),generate(3));
	  }
	  
	  public void testcommonmultiple1and1(){
		  assertEquals(1, calcMinCommonMultiple(1,1));
	  }
	  
	  public void testcommonmultiple1and2(){
		  assertEquals(2, calcMinCommonMultiple(1,2));
	  }
	  
	  public void testcommonmultiple3and2(){
		  assertEquals(6, calcMinCommonMultiple(3,2));
	  }
	  
	  public void testcommonmultiple6and8(){
		  assertEquals(24, calcMinCommonMultiple(6,8));
	  }
	  
	  public void testcommonmultiple6and9(){
		  assertEquals(18, calcMinCommonMultiple(6,9));
	  }
	  
	  public void testcommonmultipleminus6and9(){
		  assertEquals(-1, calcMinCommonMultiple(-6,9));
	  }
	  
}
