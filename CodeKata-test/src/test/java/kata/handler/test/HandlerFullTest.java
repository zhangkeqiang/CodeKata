package kata.handler.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HandlerFullTest {
    
   //
    
    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void test() {
        A1AHandlerTO a1aHandler = new A1AHandlerTO();        
        Assert.assertEquals(1004, a1aHandler.analyzeJobStep1("ddd"));
    }

}
