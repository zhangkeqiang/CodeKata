package kata.handler;

public class A1AHandler extends AHandler {
    
    @Override
    protected int analyzeJobStep1(String jobName) {
        return analyzeJobStep3(jobName);
    }


    
    public void methodmaybethrowExceptoin(String name) throws Exception{
        //blank comments
    }
    private int analyzeJobStep3(String param){
        return 3;
    }
}
