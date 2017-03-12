package kata.handler;

public class ASingletonHandler implements Handler {
    private int person = 0;
    private int job = 0;
    private ASingletonHandler() {} 
    private static final ASingletonHandler single = new ASingletonHandler();  
    public int analyzeJob(String jobName) {
        job = jobName.length();
        return person;
    }

    public int analyzePerson(String personName) {
        person = personName.length();
        return job;
    }
    
    public static Handler getInstance(){
        return single;
    }

}
