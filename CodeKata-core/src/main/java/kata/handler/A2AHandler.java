package kata.handler;

public class A2AHandler extends AHandler {
    
    @Override
    protected int analyzeJobStep1(String jobName) {
        System.out.println(jobName + " is running");
        try {
            notifyBHandler();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return analyzeJobStep2(jobName);
    }

    private void notifyBHandler() throws Exception{
        System.out.println("send message out,it is time-comsuming.");
        throw new Exception("remote service is not reachable");
        
    }
    
    public void methodmaybethrowExceptoin(String name) throws Exception{
        
    }
    
    protected int analyzeJob2(String name){
        return analyzeJobStep2(name);
    }
    private int analyzeJobStep2(String param){
        return 31;
    }
}
