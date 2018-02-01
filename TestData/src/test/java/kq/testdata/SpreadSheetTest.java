package kq.testdata;

import static org.junit.Assert.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

//@RunWith(Parameterized.class)
public class SpreadSheetTest {
	private double a;
	private double b;
	private double aTimesB;

	@Before
	public void setUp() throws Exception {
	}

	// @Parameters
	public static Collection spreadsheetData() throws IOException {
		InputStream spreadsheet = new FileInputStream("excel.xls");
		return new SpreadSheet(spreadsheet).getData();
	}

	public SpreadSheetTest() {
	}

	// public SpreadSheetTest(double a, double b, double aTimesB) {
	// super();
	// this.a = a;
	// this.b = b;
	// this.aTimesB = aTimesB;
	// }
	@Test
	public void testGetData() throws IOException {
		InputStream in = getClass().getResourceAsStream("excel.xls");
		SpreadSheet sheet = new SpreadSheet(in);
		assertNotNull(sheet);
		Collection<Object[]> data = sheet.getData();
		for (Object[] raw : data) {
			for (Object cell : raw) {
				System.out.println(cell.toString());
			}
		}
	}

}
