package kata.store;

import kata.factory.Car;
import kata.factory.CarFactory;
import kata.factory.Honda;

/**@ClassName: CarDecorationStore
 * @Description:  
 */
public class CarDecorationStore {
    public String extractCarBrand(String carName){
        Car car =CarFactory.createCar(carName);
        return car.getBrand();
    }
    
    public String decorateHonda(String message){
        Honda hondaCar = new Honda();
        return hondaCar.getBrand();
    }
}
