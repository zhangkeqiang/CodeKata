package kata.factory;

/**
 * @ClassName: BMW
 * @Description:
 */
public class Spirior extends Honda {

    public Spirior() {
        dataMap.put("key2", "Spiriorvalue");
    }

    /**
     * get Honda's path
     * 
     * @see kata.factory.Car#getPath()
     */
    @Override
    public String getPath() {
        return this.path;
    }

}
