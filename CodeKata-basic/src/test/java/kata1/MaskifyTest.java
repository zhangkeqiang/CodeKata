package kata1;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class MaskifyTest {
	Maskify mask = new Maskify();
	ArrayList<String[]> alTestData = new ArrayList<>();

	@Before
	public void setUp(){
		String[] testdata1 = { "abddssss", "####ssss" };
		String[] testdata2 = { "abdd", "abdd" };
		String[] testdata3 = { "ab", "ab" };
		String[] testdata4 = { "DOS", "DOS" };
		String[] testdata5 = { "1234567890DOSD", "##########DOSD" };
		String[] testdata6 = { "1234567890____DOSD", "##############DOSD" };

		alTestData.add(testdata1);
		alTestData.add(testdata2);
		alTestData.add(testdata3);
		alTestData.add(testdata4);
		alTestData.add(testdata5);
		alTestData.add(testdata6);
	}

	@Test
	public final void testHideLast4Chars() {
		for (String[] testdata : alTestData) {
			assertEquals(testdata[1], mask.hideLast4Chars(testdata[0]));
		}
	}
}
