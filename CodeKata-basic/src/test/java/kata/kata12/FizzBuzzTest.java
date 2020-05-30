package kata.kata12;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;   

@RunWith(Parameterized.class)
public class FizzBuzzTest {
	private int input;
	private String expected;
	private FizzBuzz fizz = new FizzBuzz();
	public FizzBuzzTest(int input, String expected) {
		this.input = input;
		this.expected = expected;
	}

	@Test
	public final void testGetFizzBuzzValue() {
		assertEquals("show message",expected, fizz.getFizzBuzzValue(input));
	}
	
	@Test
	public final void testGetFizzBuzzValuebyassertThat() {
		assertThat("check string",expected, equalTo(fizz.getFizzBuzzValue(input)));
	}

	@Parameters
	public static Collection<Object[]> prepareData() {
		Object[][] object = { { 1, "1" }, 
				{ 2, "2" }, 
				{ 3, "Fizz" },
				{ 5, "Buzz" },
				{ 6, "Fizz" },
				{ 99, "Fizz" },
				{ 15, "FizzBuzz" } };
		return Arrays.asList(object);
	}
}
