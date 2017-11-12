package kata.handler;

public class A1AHandler extends AHandler {
    
    @Override
    protected int analyzeJobStep1(String jobName) {
        return analyzeJobStep2(jobName);
    }


    
    public void methodmaybethrowExceptoin(String name) throws Exception{
        
    }
    private int analyzeJobStep2(String param){
        return 3;
    }
}
