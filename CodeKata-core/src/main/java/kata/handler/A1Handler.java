package kata.handler;

public class A1Handler extends AHandler {
    
    private int step1 = 1004;

    @Override
    protected int analyzeJobStep1(String jobName) {
        return step1;
    }

    public int analyzeJob(){
        return analyzeJobStep1("jobName");
    }
    
    public void setStep1(int i){
        this.step1 = i;
    }
}
