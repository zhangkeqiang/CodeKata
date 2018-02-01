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

public class SpreadSheetTest {
	private double a;
	private double b;
	private double aTimesB;
	InputStream in;
	SpreadSheet sheet;

	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void testGetData() throws IOException {
		in = getClass().getResourceAsStream("excel.xls");
		SpreadSheet sheet = new SpreadSheet(in);
		assertNotNull(sheet);
		Collection<Object[]> data = sheet.getData();
		for (Object[] raw : data) {
			for (Object cell : raw) {
				System.out.println(cell.toString());
			}
		}
	}

	@Test
	public void testGetColumns() throws IOException {
		in = getClass().getResourceAsStream("excel.xls");
		SpreadSheet sheet = new SpreadSheet(in);
		assertNotNull(sheet);
		Collection<String> columns = sheet.getHeader();
		for (String columnName : columns) {
			System.out.println(columnName);
		}
		assertEquals("AA", columns.toArray()[0]);
	}

}
