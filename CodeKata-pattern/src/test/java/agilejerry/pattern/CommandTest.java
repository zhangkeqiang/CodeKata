package agilejerry.pattern;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;



public class CommandTest{

	@Test
    public void test1(){
    	assertTrue(true);
    }
    
	@Test
    public void testExecute(){
    	ArrayList<Command> list = new ArrayList<Command>();
    	list.add(new AACommand());
    	list.add(new ABCommand());
    	list.add(new AACommand(45));
    	list.add(new ABCommand(32));
    
    	for (Iterator<Command> it = list.iterator(); it.hasNext(); ){
    		assertTrue(it.next().execute());
        }
    
   }
}