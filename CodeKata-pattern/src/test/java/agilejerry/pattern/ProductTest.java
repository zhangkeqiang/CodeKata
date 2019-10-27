package agilejerry.pattern;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProductTest {
	Product p;
	@Before
	public void setUp(){		
		p = SimpleFactory.CreateProduct();
	}
	@Test
	public void testFly() {		    
		p.fly();
		assertTrue(true);
	}
	
	@Test
	public void testCalc(){		
		assertEquals(268, p.calc());
	}
}
