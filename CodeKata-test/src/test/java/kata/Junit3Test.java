package kata;

import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */

public class Junit3Test  extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */     
    public Junit3Test( String testName )
    {
        super( testName );
    }


    public void testAppOne()
    {
        assertTrue( true );
    	assertNotNull(new TestSuite( Junit3Test.class )); 
    }
    
    public void testAppTwo()
    {
        assertTrue( true );
    	
    }

    
    public void testAppThree()
    {
        assertTrue( true );
    	
    }
    

    
    public void testAppFour()
    {
        assertTrue( true );
    	
    }
    /*
    ***/
    
    public void testAppFive()
    {
        assertTrue( true );
    	
    }  

    

    
    public void testAppSix3()
    {
        assertTrue( true );
    	
    }
}
