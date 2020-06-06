package kata.handler;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AHandler implements Handler {

    protected static final Logger logger = LogManager.getLogger(AHandler.class);
    
    
    public int analyzeJob(String jobName) {
        int step1 = analyzeJobStep1(jobName);
       
        return step1;
    }
    

    protected int analyzeJobStep1(String jobName) {
        
        return analyzeJobStep2(jobName);
    }

    private int analyzeJobStep2(String jobName) {
        
    	return jobName.length();
    }

    public int analyzePerson(String personName) {
        return 0;
    }

}
