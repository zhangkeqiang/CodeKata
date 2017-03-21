package kata.testassist;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BaseTestTest extends BaseTest {
    
    /*    @Before
    public void setUp() throws Exception {
        
    }

    @After
    public void tearDown() throws Exception {        
        super.tearDown();
    }*/
    @Test
    public final void testRun() {
        logger.warn("write test run here");
        //logger.debug("debug");
    }
} 
/*
    @Test
    public void testLog4j2() {
        logger.info(name.getMethodName());
        assertNotNull(logger);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
    }
    
}
   //@Test
    public void testLog4j2debug() {
        logger.debug("debug message");
        logger.debug("debug message2");
    }

    @Test
    public void testLog4j2fatal() {
        logger.fatal("fatal message");
    }
}
*/