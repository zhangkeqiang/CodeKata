package kata.handler;

import static org.junit.Assert.*;

import java.lang.reflect.Method;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.testassist.BaseTest;

/**@ClassName: HandlerCenterTest
 * @Description:  
 */
public class HandlerCenterTest extends BaseTest{

    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * Test method for {@link kata.handler.HandlerCenter#getSingletonHandler(java.lang.String)}.
     */
    @Test
    public final void testGetSingletonHandler() {
        String handlerName = "BSingletonHandler";
        Handler handler = HandlerCenter.getSingletonHandler(handlerName );
        assertNotNull(handler);
    }

    @Test
    public final void testBSingletonHandler() throws Exception{
        String handlerName = "BSingletonHandler";
        Class aclass = Class.forName("kata.handler."+handlerName);
        Method getInstanceMethod = aclass.getMethod("getInstance");
        Handler handler = (Handler) getInstanceMethod.invoke(null);
        assertNotNull(handler);
        assertEquals("kata.handler.BSingletonHandler", handler.getClass().getName());
        assertEquals(333, handler.analyzePerson(""));        
    }
    
    @Test
    public final void testASingletonHandler() throws Exception{
        String handlerName = "ASingletonHandler";
        Class aclass = Class.forName("kata.handler."+handlerName);
        Method getInstanceMethod = aclass.getMethod("getInstance");
        Handler handler1 = (Handler) getInstanceMethod.invoke(null);
        assertNotNull(handler1);
        assertEquals("kata.handler.ASingletonHandler", handler1.getClass().getName());
        assertEquals(0, handler1.analyzePerson("12345678"));
        Handler hander4 = HandlerCenter.getSingletonHandler(handlerName);
        assertSame(handler1, hander4);
        Handler hander2 = HandlerCenter.getReadyHandler(handlerName);
        assertSame(handler1, hander2);
        Handler hander3 = HandlerCenter.getHandler(handlerName);
        assertSame(handler1, hander3);

    }
    
    @Test
    public final void testGetReadyHandlerB() {
        String handlerName = "BSingletonHandler";
        Handler handler = HandlerCenter.getReadyHandler(handlerName);
        assertNotNull(handler);
        assertEquals("kata.handler.BSingletonHandler", handler.getClass().getName());
        assertTrue(handler instanceof Handler);
        assertTrue(handler instanceof AbstractHandler);
        assertEquals(333, handler.analyzePerson(""));
    }
    
    @Test
    public final void testGetReadyHandlerA() {
        String handlerName = "ASingletonHandler";
        Handler handler = HandlerCenter.getReadyHandler(handlerName);
        assertNotNull(handler);
        assertEquals("kata.handler.ASingletonHandler", handler.getClass().getName());
        assertTrue(handler instanceof ASingletonHandler);
        assertTrue(handler instanceof Handler);
        assertEquals("person init 0",0, handler.analyzePerson(""));
    }
}
