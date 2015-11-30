package kata;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.junit.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4j2Test {
	static Logger logger;
	static int i = 0;
	static int j = 0;
	@Before 
	public void init() {
		logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
		logger.info("init time:" + (++i));
	}
	@After
	public void tearDown() throws Exception {
		logger.info("after time:" + i);
	}

	@BeforeClass
	public static void beforeClass(){
		LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("beforeclass time:" + (++j));
	}
	
	@AfterClass
	public static void afterClass(){
		LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("afterclass time:" + (j));
	}
	@Test
	public void testLog4j2() {
		assertNotNull(logger);
        logger.trace("trace message");
        logger.debug("debug message");
        logger.info("info message");
        logger.warn("warn message");
        logger.error("error message");
        logger.fatal("fatal message");
	}
	
	
	@Test
	public void testLog4j2debug() {		
        logger.debug("debug message");
        logger.debug("debug message2");
	}
	
	@Test
	public void testLog4j2fatal() {		
        logger.fatal("fatal message");
	}

}
