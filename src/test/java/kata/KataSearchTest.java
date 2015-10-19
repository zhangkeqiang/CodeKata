package kata;

import junit.framework.TestCase;

import kata.KataSearch;

public class KataSearchTest   extends TestCase {
	int array[] = {1,3,5,7,9,11,13,15,16,34,56,78,98,100};
	KataSearch search;
    public KataSearchTest( String testName )
    {
        super( testName );
    }
	
	protected void setUp() throws Exception {
		super.setUp();
		search = new KataSearch();
	}
    
    public void testOne() throws Exception {
		  assertEquals(0,  search.chop(1, array)) ;		  
    }

    public void testTwo() throws Exception {
		  assertEquals(-1,  search.chop(2, array)) ;		  
    }
    public void testThree() throws Exception {
		  assertEquals(1,  search.chop(3, array)) ;		  
    }
    
    public void test13()
    {
    	
    	assertEquals(6,  search.chop(13, array)) ;
    }
    
    public void test9inchop2()
    {
    	
    	assertEquals(4,  search.chop2(9, array)) ;
    }
    
    public void test5inchop2(){
    	assertEquals(2,  search.chop2(5, array)) ;
    }
    
    public void test13inchop2(){
    	assertEquals(6,  search.chop2(13, array)) ;
    }
    
    public void test1inchop2(){
    	assertEquals(0,  search.chop2(1, array)) ;
    }
    
    public void test16inchop2(){
    	assertEquals(8,  search.chop2(16, array)) ;
    }
    
    public void test168inchop2(){
    	assertEquals(-1,  search.chop2(168, array)) ;
    }
    
    public void test3inchop2(){
    	assertEquals(1,  search.chop2(3, array)) ;
    }
    
    public void test2inchop2(){
    	assertEquals(-1,  search.chop2(2, array)) ;
    }
    
    public void test0inchop2(){
    	assertEquals(-1,  search.chop2(0, array)) ;
    }
    
}
