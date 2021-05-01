package kata.excel;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.junit.Test;

public class ZMExcelTest {

	@Test
	public final void testgetExampleList() {

		String filepath = "E:\\VSCode\\SimpleOpen\\ScrumBan\\Excel\\ExcelBDD.xlsx";
		Collection<Object[]> list = ZMExcel.getExampleList(filepath, "SimpleOpenBDD", 1, 'D');

	}
	
	@Test
	public final void test() {
		char parameterNameColumn = 'D';
		int parameterNameColumnNum = (int)parameterNameColumn - 64;
		assertEquals(parameterNameColumnNum, 4);
	}
}
