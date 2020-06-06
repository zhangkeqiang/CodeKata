package kata.store;

import static org.junit.Assert.*;

import org.junit.Test;

public class CarDecorationStoreNormalTest {

	@Test
	public final void testDecorateHonda() {
		CarDecorationStore store = new CarDecorationStore();
		assertNotNull(store.decorateHonda("message"));
	}

}
