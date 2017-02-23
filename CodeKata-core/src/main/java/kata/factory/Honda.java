package kata.factory;

/**@ClassName: BMW
 * @Description:  
 */
public class Honda extends Car {
    
    /**
     * default constructor of Honda
     */
    public Honda(){
        dataMap.put("key1","value1");
        dataMap.put("key2", "Hondavalue2");
    }
    @Override
    public String getBrand(){
        return "Honda";
    }
    

}
