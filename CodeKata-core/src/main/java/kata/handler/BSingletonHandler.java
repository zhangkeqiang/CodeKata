package kata.handler;

public class BSingletonHandler extends AbstractHandler {

    private BSingletonHandler() {} 
    private static final BSingletonHandler single = new BSingletonHandler();  
    public int analyzeJob(String jobName) {
       
        return 12;
    }

    public int analyzePerson(String personName) {
        return 333;
    }
    
    public static Handler getInstance(){
        return single;
    }

}
