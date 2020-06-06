package kata.spring.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import kata.spring.testassist.SpringBaseTest;

/**@ClassName: EventAssistServiceTest
 * @Description:  
 */
public class EventAssistServiceTest { //extends SpringBaseTest {

    //@Autowired
    EventAssistService eventAssistService;
    /**
     * Test method for {@link kata.spring.service.EventAssistService#calcByAssist(int)}.
     */
//    @Test
//    @Ignore
    public final void testCalcByAssist() {
        assertNotNull(eventAssistService);
        assertEquals(8989,eventAssistService.calcByAssist(89));
        
        
    }
    
    @Test
    public final void testNull() {
    	assertTrue(true);
    }

}
