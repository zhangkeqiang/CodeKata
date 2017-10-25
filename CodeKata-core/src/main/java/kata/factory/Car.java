package kata.factory;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Car
 * @Description:
 */
public abstract class Car {

    /**
     * DEFAULT_PATH:TODO
     */
    
    private static final String DEFAULT_PATH = "defaultPath";

    /*
     * Car
     */
    public Car() {
        dataMap.put("key0", "value0");
        dataMap.put("key2", "value2");
        
    }

    /**
     * @method getBrand
     * @description
     * @return Brand
     */
    public abstract String getBrand();

    protected Map<String, String> dataMap = new HashMap<String, String>();

    public String getValueByKey(String key) {
        String value = dataMap.get(key);
        return value;
    }

    /**@method getPath
     * @description 
     * @return Object
    */
    public String getPath(){
        return DEFAULT_PATH;
    }
    
    public Map getDataMap(){
        return this.dataMap;
    }
}
