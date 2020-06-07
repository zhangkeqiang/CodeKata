package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import static org.powermock.api.mockito.PowerMockito.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Settings.class)
public class FactoryTest {

	@Test
	public void testCreateAAProduct() {
		Product product = SimpleFactory.createProduct();
		assertNotNull(product);
		assertTrue(product instanceof AAProduct);
	}
	
	
	@Test
	public void testCreateABProduct() throws Exception{
		mockStatic(Settings.class);
		when(Settings.getProduct()).thenReturn("AB");
		Product product = SimpleFactory.createProduct();
		assertNotNull(product);
		assertTrue(product instanceof ABProduct);
		verifyStatic();
	}
	

}
