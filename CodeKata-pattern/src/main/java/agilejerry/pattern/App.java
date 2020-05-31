package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Hello world!
 *
 */
public class App 
{
	static Logger logger = LogManager.getLogger(); 
    public static void main( String[] args )
    {
    	processMain();
    }
    
    static void processMain() {
    	 logger.info( "Hello World!" );
    }
}
