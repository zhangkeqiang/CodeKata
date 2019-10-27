package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Test;

public class FactoryTest {

	@Test
	public void testCreateProduct() {
		//SimpleFactory factory = new SimpleFactory();
		//assertNotNull(factory);
		Product product = SimpleFactory.CreateProduct();
		assertNotNull(product);
		
	}

}
