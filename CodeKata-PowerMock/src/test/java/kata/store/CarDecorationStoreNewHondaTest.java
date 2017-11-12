package kata.store;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.mockito.PowerMockito.*;

import kata.factory.BMW;
import kata.factory.Car;
import kata.factory.CarFactory;
import kata.factory.Honda;

/**
 * @ClassName: CarDecorationStoreTest
 * @Description:
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(CarDecorationStore.class)
public class CarDecorationStoreNewHondaTest {

    /**
     * @method setUp
     * @description
     * @return void
     */
    @Before
    public void setUp() throws Exception {
    }

    /**
     * @method tearDown
     * @description
     * @return void
     */
    @After
    public void tearDown() throws Exception {
    }

    @Test
    public final void testdecorateHonda() throws Exception {
        CarDecorationStore store = new CarDecorationStore();
        Honda mockHonda = mock(Honda.class);
        String carMessage = "mockHonda";
        when(mockHonda.getBrand()).thenReturn(carMessage);
        whenNew(Honda.class).withNoArguments().thenReturn(mockHonda);
        String brand1 = store.decorateHonda("message");
        assertEquals(carMessage, brand1);
        verifyNew(Honda.class, Mockito.times(1)).withNoArguments();
    }

    @Test(expected = IOException.class)
    public final void testdecorateHondaThrowException() throws Exception {
        CarDecorationStore store = new CarDecorationStore();
        Honda mockHonda = mock(Honda.class);
        String carMessage = "mockHonda";
        when(mockHonda.getBrand()).thenReturn(carMessage);
        whenNew(Honda.class).withNoArguments().thenThrow(new IOException("throw error message"));
        String brand1 = store.decorateHonda("message");
        assertEquals(carMessage, brand1);
        verifyNew(Honda.class, Mockito.times(1)).withNoArguments();
    }
}
