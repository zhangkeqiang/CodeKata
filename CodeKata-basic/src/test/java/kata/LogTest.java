
package kata;


import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

//import org.apache.log4j.Logger;
//import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogTest{

	private static Logger logger ;

	@Before
	public void setUp() throws Exception {
		logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	}


	@Test
	public void testLog1()	{	
		logger.info("info, World1!");   
        logger.warn("warn, World2!");        
        logger.error("error, World4!"); 
        logger.fatal("Here is some FATAL");
		assertTrue(true);
	}
}
