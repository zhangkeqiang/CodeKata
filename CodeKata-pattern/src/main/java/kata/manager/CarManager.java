package kata.manager;

import java.util.HashMap;
import java.util.Map;

import kata.factory.Car;
import kata.factory.CarFactory;

/**@ClassName: CarManager
 * @Description:  
 */
public class CarManager {

    private static Map map = new HashMap<String, Car>();
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

}
