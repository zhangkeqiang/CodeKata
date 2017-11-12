package kata.handler.test;



import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import kata.handler.A1AHandler;
import kata.testassist.BaseTest;

import static org.mockito.Mockito.*;


import static org.mockito.Mockito.*;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;



@RunWith(PowerMockRunner.class) 
@PrepareForTest(A1AHandler.class) 
public class HandlerTestWithPowerMock{

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    
    @Test
    public void testPrivateMethod() throws Exception {
        A1AHandler a1aHandler =(A1AHandler) PowerMockito.spy(new A1AHandler()); 
        /* 
         * Setup the expectation to the private method using the method name 
         */
        int expected = 56;
        PowerMockito.doReturn(expected).when(a1aHandler, "analyzeJobStep2", "jobA");
        Assert.assertEquals(expected, a1aHandler.analyzeJob("jobA")); 

        // Optionally verify that the private method was actually called 
        PowerMockito.verifyPrivate(a1aHandler,times(1)).invoke("analyzeJobStep2", "jobA"); 
    }
    
    @Test
    public void testWithMockito() throws Exception {
        A1AHandler a1aHandler =(A1AHandler) PowerMockito.spy(new A1AHandler()); 
//        A1AHandler a1aHandler = mock(A1AHandler.class);
        /* 
         * Setup the expectation to the private method using the method name 
         */
        int expected = 103;
        Mockito.when(a1aHandler.analyzeJob("JobB")).thenReturn(103);
       
        int actual = a1aHandler.analyzeJob("JobB");
        Assert.assertEquals(103, actual); 
        Assert.assertEquals(expected, a1aHandler.analyzeJob("JobB")); 

        Mockito.verify(a1aHandler, times(3)).analyzeJob("JobB");
    }
    
    @Test
    public void testExceptionwithMock() throws Exception{
        A1AHandler a1aHandler = mock(A1AHandler.class);
        doThrow(new Exception("hahahaha")).when(a1aHandler).methodmaybethrowExceptoin("DDD");
        try{
            a1aHandler.methodmaybethrowExceptoin("BBB");
            Assert.assertTrue(true);
        }catch(Exception e){
            Assert.assertTrue(false);
        }
        
        try{
            a1aHandler.methodmaybethrowExceptoin("DDD");
            Assert.assertTrue(false);
        }catch(Exception e){
            System.out.println(e);
            Assert.assertTrue(true);
        }
        
        Mockito.verify(a1aHandler, times(1)).methodmaybethrowExceptoin("DDD");
    }

}
