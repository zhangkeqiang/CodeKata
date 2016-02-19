package kata.handler.test;

import kata.handler.A1AHandler;

public class A1AHandlerTO extends A1AHandler {
    @Override
    public int analyzeJobStep1(String jobName){
        return super.analyzeJobStep1(jobName);
    }
    
    public int analyzeJobStep2(String param){
        return 3;
    }
}
