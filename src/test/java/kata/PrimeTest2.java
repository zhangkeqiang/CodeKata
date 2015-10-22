package kata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeTest2 {

    private int Input;
    private int Expected;
    public PrimeTest2(int expected, int input){
    	Input = input;
    	Expected = expected;
    }
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Parameters
    public static Collection data()
    {
        return Arrays.asList(new Object[][] { { 2, 2 }, { 3, 3 }, { 3, 4 },
                { 5, 5 }, { 23, 24 }, { 5, 6 }, { 7, 9 }, { 97, 100 }});
    }
	@Test
	public void test() {
		assertEquals(Expected, Prime.searchMaxPrime(Input));
		//assertEquals(3, Prime.searchMaxPrime(4));
    }

}
