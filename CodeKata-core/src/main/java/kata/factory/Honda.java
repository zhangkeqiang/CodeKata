package kata.factory;

/**@ClassName: BMW
 * @Description:  
 */
public class Honda extends Car {
    
    private String path = "HondaPath";
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
    /** get Honda's path
     * @see kata.factory.Car#getPath()
     */
    @Override
    public String getPath() {
        return this.path;
    }
    

}
