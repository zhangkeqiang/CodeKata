package kata.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @ClassName: CarFactory
 * @Description:
 */
public class CarFactory {
	static Logger logger = LogManager.getLogger(CarFactory.class);

	/**
	 * @method createCar
	 * @description
	 * @return Car
	 */
	public static Car createCar(String carName) {
		Car car = null;
		try {
			car = (Car) Class.forName("kata.factory." + carName).newInstance();
		} catch (InstantiationException e) {
			// Auto-generated catch block
			logger.error(e);
		} catch (IllegalAccessException e) {
			// Auto-generated catch block
			logger.error(e);
		} catch (ClassNotFoundException e) {
			logger.warn(e);
			car = new DefaultCar();
		}
		return car;
	}

}
