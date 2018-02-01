package kq.testdata;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SpreadSheetParameterizedTest {
	private String a;
	private String b;
	private int indexOfA;

	@Before
	public void setUp() throws Exception {
	}

	@Parameters
	public static Collection loadSpreadSheetData() throws IOException {
		SpreadSheetParameterizedTest test = new SpreadSheetParameterizedTest("", "", 0,0);
		URL url = test.getClass().getResource("excel.xls");
		System.out.println(url);
		InputStream in = test.getClass().getResourceAsStream("excel.xls");
		SpreadSheet sheet = new SpreadSheet(in);
		return sheet.getData();
	}

	public SpreadSheetParameterizedTest(String a, String b, double indexOfA,double abs) {
		System.out.println(a + "|" + b + "|" + indexOfA);
		this.a = a;
		this.b = b;
		this.indexOfA = (int) indexOfA;
	}

	@Test
	public void testGetData() throws IOException {
		System.out.println(a + "|" + b + "|" + indexOfA);
		assertEquals(indexOfA, a.indexOf(b));
	}

}
