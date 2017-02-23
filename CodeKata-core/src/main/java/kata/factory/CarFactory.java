package kata.factory;

/**@ClassName: CarFactory
 * @Description:  
 */
public class CarFactory {

    /**@method createCar
     * @description 
     * @return Car
    */
    public static Car createCar(String carName) {
        Car car = null;
        try {
            car = (Car) Class.forName("kata.factory."+carName).newInstance();
        } catch (InstantiationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return car;
    }

}
