package kata.handler;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import kata.IncomeTax;


/**@ClassName: A2AHandlerTest
 * @Description:  
 */
@RunWith(MockitoJUnitRunner.class)
public class A2AHandlerTestByMockito {

    /**
     * jobA:TODO
     */
    
    private static final String jobA = "jobA";

    /**@method setUpBeforeClass
     * @description 
     * @return void
    */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**@method tearDownAfterClass
     * @description 
     * @return void
    */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

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
    public final void testMockProtectedAnalyzeJobStep1() throws Exception{
        A2AHandler a2AHandler =new A2AHandler();
        A2AHandler spyA2AHandler = Mockito.spy(a2AHandler);
        int expected = 56;        
        Mockito.doReturn(expected).when(spyA2AHandler).analyzeJobStep1(jobA);
        assertEquals(expected, spyA2AHandler.analyzeJob(jobA));
    }

    @Test
    public final void testMockProtectedAnalyzeJobStep1Directly(){
        A2AHandler handler = mock(A2AHandler.class);
        int expected = 56; 
        //when(handler.analyzeJob(jobA)).thenReturn(expected);
        
        
        when(handler.analyzeJobStep1(jobA)).thenReturn(expected);
        assertEquals(expected, handler.analyzeJobStep1(jobA));
        assertEquals(0, handler.analyzeJob(jobA));
    }
  
}
