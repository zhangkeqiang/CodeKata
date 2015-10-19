package kata;

import junit.framework.TestCase;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LogTest extends TestCase {

	private static Logger logger ;
	public LogTest(String name) {
		super(name);
		PropertyConfigurator.configure("log4j.properties");
		logger = Logger.getLogger(LogTest.class);
		

	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testLog1()	{	
		logger.info("info, World1!");   
        logger.warn("warn, World2!");        
        logger.error("error, World4!"); 
        logger.fatal("Here is some FATAL");
		assertTrue(true);
	}
}
