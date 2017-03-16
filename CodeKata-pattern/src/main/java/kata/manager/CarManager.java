package kata.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kata.factory.Car;
import kata.factory.CarFactory;

/**@ClassName: CarManager
 * @Description:  
 */
public class CarManager {

    private Map map = new HashMap<String, Car>();
    private List list = new ArrayList<Car>(); 
    /**
     * @method getCar
     * @description 
     * @param carName: name of car
     * @return Car
     */
    public Car getCar(String carName) {
        Car car = (Car) map.get(carName);
        if(car == null){
            car = CarFactory.createCar(carName);
            map.put(carName, car);
        }
        return car;
    }
    /**@method getCount
     * @description 
     * @return Object
    */
    public int getCount() {
        return map.size();
    }
    /**@method make
     * @description 
     * @return Car
    */
    public static Car make() {
        String carName = "noname";
        return CarFactory.createCar(carName );
    }
    /**@method save
     * @description 
     * @return boolean
    */
    public boolean save(Car car) {
        list.add(car);
        return true;
    }

}
