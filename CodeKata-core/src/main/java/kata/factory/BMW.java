package kata.factory;

/**@ClassName: BMW
 * @Description:  
 */
public class BMW extends Car {
    @Override
    public String getBrand(){
        return "BMW";
    }
    
    /**
     * BMW
     */
    public BMW(){
        dataMap.put("keyBMW", "BMW7i");
    }


}
