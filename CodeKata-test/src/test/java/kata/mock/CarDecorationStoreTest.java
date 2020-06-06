package kata.mock;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import kata.factory.BMW;
import kata.factory.CarFactory;
import kata.factory.Honda;
import kata.store.CarDecorationStore;

/**@ClassName: CarDecorationStoreTest
 * @Description:  
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CarFactory.class)
public class CarDecorationStoreTest {

    /**@method setUpBeforeClass
     * @description 
     * @return void
    */
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    /**@method tearDownAfterClass
     * @description 
     * @return void
    */
    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**@method setUp
     * @description 
     * @return void
    */
    @Before
    public void setUp() throws Exception {
    }

    /**@method tearDown
     * @description 
     * @return void
    */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * Test method for {@link kata.store.CarDecorationStore#extractCarBrand(java.lang.String)}.
     */
    @Test
    public final void testPrintCarBrand() {
        CarDecorationStore store = new CarDecorationStore();
        String car1Name = "Honda";
        String brand1 = store.extractCarBrand(car1Name );
        assertEquals(car1Name, brand1);
        String car2Name = "Spirior";
        String brand2 = store.extractCarBrand(car2Name );
        assertEquals(brand1, brand2);
    }
    
    @Test
    public final void testPrintCarNotExistedBrandWithPowerMock() {
        PowerMockito.mockStatic(CarFactory.class);
        String car1Name = "MG7";
        String car2Name = "Spirior";
        Mockito.when(CarFactory.createCar(car1Name)).thenReturn(new Honda());
        Mockito.when(CarFactory.createCar(car2Name)).thenReturn(new BMW());
        CarDecorationStore store = new CarDecorationStore();
        String brand1 = store.extractCarBrand(car1Name );
        assertEquals("Honda", brand1);        
        String brand2 = store.extractCarBrand(car2Name );
        assertEquals("BMW", brand2);
        
        PowerMockito.verifyStatic(Mockito.times(1));
        CarFactory.createCar(car1Name);
        
        PowerMockito.verifyStatic(Mockito.times(1));
        CarFactory.createCar(car2Name);
        
        PowerMockito.verifyStatic(Mockito.never());
        CarFactory.createCar("car3Name");
        
    }

    @Test
    public final void testPrintCarNotExistedBrand() {
//        PowerMockito.mockStatic(CarFactory.class);
        String car1Name = "Spirior";
        String car2Name = "BMW";
//        Mockito.when(CarFactory.createCar(car1Name)).thenReturn(new Honda());
//        Mockito.when(CarFactory.createCar(car2Name)).thenReturn(new BMW());
        CarDecorationStore store = new CarDecorationStore();
        String brand1 = store.extractCarBrand(car1Name );
        assertEquals("Honda", brand1);        
        String brand2 = store.extractCarBrand(car2Name );
        assertEquals("BMW", brand2);
        
//        PowerMockito.verifyStatic(Mockito.times(0));
//        CarFactory.createCar(car1Name);
//        
//        PowerMockito.verifyStatic(Mockito.times(0));
//        CarFactory.createCar(car2Name);
        
    }
    
    @Test
    public final void testdecorateHonda() {
//        PowerMockito.mockStatic(CarFactory.class);
        String car1Name = "Spirior";
        String car2Name = "BMW";
//        Mockito.when(CarFactory.createCar(car1Name)).thenReturn(new Honda());
//        Mockito.when(CarFactory.createCar(car2Name)).thenReturn(new BMW());
        CarDecorationStore store = new CarDecorationStore();
        String brand1 = store.decorateHonda("message");
        assertEquals("Honda", brand1);        

        
//        PowerMockito.verifyStatic(Mockito.times(0));
//        CarFactory.createCar(car1Name);
//        
//        PowerMockito.verifyStatic(Mockito.times(0));
//        CarFactory.createCar(car2Name);
        
    }
    
}
