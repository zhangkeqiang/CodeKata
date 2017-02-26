package kata.handler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**@ClassName: A2AHandlerTest
 * @Description:  
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(A2AHandler.class)
public class A2AHandlerTest {

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
        A2AHandler a2AHandler =(A2AHandler) PowerMockito.spy(new A2AHandler());
        int expected = 56;        
        PowerMockito.doReturn(expected).when(a2AHandler, "analyzeJobStep1", "jobA");
        assertEquals(expected, a2AHandler.analyzeJob("jobA"));
    }

    @Test
    public final void testMockPrivateAnalyzeJobStep2() throws Exception{
        A2AHandler a2AHandler =(A2AHandler) PowerMockito.spy(new A2AHandler());
        int expected = 56;
        PowerMockito.doReturn(expected).when(a2AHandler, "analyzeJobStep2", "jobA");
        assertEquals(expected, a2AHandler.analyzeJob2("jobA"));
    }
    
    @Test
    public final void testMockPrivateVoidNotify() throws Exception{
        A2AHandler a2AHandler =(A2AHandler) PowerMockito.spy(new A2AHandler());
        int expected = 56;
        PowerMockito.doReturn(expected).when(a2AHandler, "analyzeJobStep2", "jobA");        
        PowerMockito.doNothing().when(a2AHandler, "notifyBHandler");
        assertEquals(expected, a2AHandler.analyzeJob("jobA"));
    }
    
    @Test
    public final void testNoMock() throws Exception{
        A2AHandler a2AHandler =(A2AHandler) PowerMockito.spy(new A2AHandler());
        int expected = 0;
        //PowerMockito.doReturn(expected).when(a2AHandler, "analyzeJobStep2", "jobA");        
        //PowerMockito.doNothing().when(a2AHandler, "notifyBHandler");
        assertEquals(expected, a2AHandler.analyzeJob("jobA"));
    }
}
