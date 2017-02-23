package kata.factory;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**@ClassName: CarFactoryTest
 * @Description:  
 */
public class CarFactoryTest {

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

    @Test
    public final void BMW_Car_should_be_created() {
        Car bmw = CarFactory.createCar("BMW");
        assertNotNull(bmw);
        assertEquals("BMW", bmw.getBrand());
        assertEquals("value0",bmw.getValueByKey("key0"));
        assertEquals(null,bmw.getValueByKey("key1"));
        assertEquals("BMW7i",bmw.getValueByKey("keyBMW"));
        assertEquals("value2",bmw.getValueByKey("key2"));
        
        
    }
    
    @Test
    public final void Honda_Car_should_be_created() {
        Car honda = CarFactory.createCar("Honda");
        assertNotNull(honda);
        assertEquals("Honda", honda.getBrand());
        assertEquals("value1",honda.getValueByKey("key1"));
        assertEquals("value0",honda.getValueByKey("key0"));
        assertEquals("Hondavalue2",honda.getValueByKey("key2"));
    }

}
