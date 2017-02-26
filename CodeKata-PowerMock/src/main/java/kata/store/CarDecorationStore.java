package kata.store;

import kata.factory.Car;
import kata.factory.CarFactory;

/**@ClassName: CarDecorationStore
 * @Description:  
 */
public class CarDecorationStore {
    public String extractCarBrand(String carName){
        Car car =CarFactory.createCar(carName);
        return car.getBrand();
    }
}
