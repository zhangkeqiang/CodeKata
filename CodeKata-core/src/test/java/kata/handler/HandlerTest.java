package kata.handler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HandlerTest {

    AHandler handlerA = new AHandler();
    BHandler handlerB = new BHandler();
    A1Handler handlerA1 = new A1Handler();
    @Before
    public void setUp() throws Exception {
        addHandlersToCenter();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void all_type_of_Handler_can_be_added_to_HandlerCenter() {

        addHandlersToCenter();
    }

    private void addHandlersToCenter() {
        HandlerCenter.addHandler("AHandler", handlerA);       
        HandlerCenter.addHandler("BHandler", handlerB);
        HandlerCenter.addHandler("A1Handler", handlerA1);
    }

    @Test
    public void any_Handler_can_be_getted_from_HandlerCenter() {
        
        Handler A = HandlerCenter.getHandler("AHandler");
        Assert.assertNotNull(A);
        Handler notExistedHandler = HandlerCenter.getHandler("notExistedHandler");
        Assert.assertNull(notExistedHandler);
        
    }
    
    @Test
    public void suitable_handler_can_be_find_to_do_good_job(){
        Handler B = HandlerCenter.getHandler("BHandler");
        Assert.assertEquals(12, B.analyzeJob("Good Job"));
        Handler A = HandlerCenter.getHandler("AHandler");
        Assert.assertEquals(1003, A.analyzeJob("Good Job"));
        Handler A1 = HandlerCenter.getHandler("A1Handler");
        Assert.assertEquals(1004, A1.analyzeJob("Good Job"));
        
    }
}
