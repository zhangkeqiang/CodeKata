package kata.manager;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.factory.Car;
import kata.testassist.BaseTest;

/**
 * @ClassName: CarManagerTest
 * @Description:
 */
public class CarManagerTest extends BaseTest{

    CarManager manager = new CarManager();

    @Before
    public void setUp() throws Exception {
        assertNotNull(manager);
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public final void testgetCar() {
        String carName = "BMW";
        Car car = manager.getCar(carName);
        assertNotNull(car);
        Car car2 = manager.getCar(carName);
        assertNotNull(car2);
        assertSame(car, car2);
    }

    @Test
    public final void testget100Car() {
        String carName = "BMW";
        for (int i = 0; i < 100; i++) {
            Car car = manager.getCar(carName + i);
            assertNotNull(car);
        }
        assertEquals(true, 99 < manager.getCount());
        
        Car car19 = manager.getCar("BMW19");
        logger.info(car19.getPath());
        assertEquals("DefautCarBrand", car19.getBrand());
    }
    
    @Test
    public final void testsaveACar(){
        Car car = CarManager.make();
        assertTrue(manager.save(car));
    }
}
