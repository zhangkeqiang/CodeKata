package kata.mock;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Assert;
import org.junit.Test;
import kata.IncomeTax;



public class MockTest {

	@Test
	public final void testMock() {
		IncomeTax mockIncomeTax = mock(IncomeTax.class);
		when(mockIncomeTax.calculate(45600)).thenReturn((double) 234);
		Assert.assertEquals((double)234, mockIncomeTax.calculate(45600),1);
	}

}
