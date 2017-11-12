package kata.handler;

import static org.junit.Assert.*;


import static org.mockito.Mockito.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**@ClassName: A2AHandlerTest
 * @Description:  
 */
@RunWith(MockitoJUnitRunner.class)
public class A2AHandlerTestByMockito {

    /**
     * jobA:TODO
     */
    
    private static final String jobA = "jobA";

 

    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
    }

    /**@method tearDown
     * @description 
     * @return void
    */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link kata.handler.A2AHandler#analyzeJobStep1(java.lang.String)}.
     * @throws Exception 
     */
    @Test
    public final void testMockProtectedAnalyzeJobStep1InA2AHandler() throws Exception{
        A2AHandler a2AHandler =new A2AHandler();
        A2AHandler spyA2AHandler = Mockito.spy(a2AHandler);
        int expected = 56;        
        doReturn(expected).when(spyA2AHandler).analyzeJobStep1(jobA);
        assertEquals(expected, spyA2AHandler.analyzeJob(jobA));
    }

    @Test
    public final void testMockProtectedAnalyzeJobStep1() throws Exception{
        AHandler aHandler =new AHandler();
        AHandler spyA2AHandler = Mockito.spy(aHandler);
        int expected = 56;        
        doReturn(expected).when(spyA2AHandler).analyzeJobStep1(jobA);
        assertEquals(expected, spyA2AHandler.analyzeJob(jobA));
    }
    @Test
    public final void testMockProtectedAnalyzeJobStep1Directly(){
        A2AHandler handler = mock(A2AHandler.class);
        int expected = 56; 
        when(handler.analyzeJobStep1(jobA)).thenReturn(expected);
        when(handler.analyzeJob2(jobA)).thenReturn(expected);
        assertEquals(expected, handler.analyzeJobStep1(jobA));
        
        assertEquals(0, handler.analyzeJob(jobA));
        verify(handler).analyzeJobStep1(jobA);
        verify(handler, never()).analyzeJob2(jobA);
    }
    
    @Test(expected = Exception.class) 
    public final void testMockThrowException(){
        A2AHandler handler = mock(A2AHandler.class);
        System.out.println("jobstep1 is starting");
        when(handler.analyzeJobStep1(jobA)).thenThrow(new Exception());
        int i = handler.analyzeJobStep1(jobA);
        System.out.println("jobstep1 is " + i);
        
    }
  
}
