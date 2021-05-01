package kata.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZMExcel {

	public static Collection<Object[]> getExampleList(String excelPath, String worksheetName, int headerRow,
			char parameterNameColumn) {
		ArrayList<Object[]> listTestData = new ArrayList<Object[]>();
		try {
			int parameterNameColumnNum = (int) parameterNameColumn - 65;
			System.out.println("parameterNameColumnNum:" + parameterNameColumnNum);

			FileInputStream excelFile = new FileInputStream(new File(excelPath));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheetTestData = workbook.getSheet(worksheetName);
			System.out.println("RowSum:" + sheetTestData.getLastRowNum());
			XSSFRow rowHeader = sheetTestData.getRow(headerRow - 1);
			System.out.println("Column Sum:" + rowHeader.getLastCellNum());
			// Get ParameterNames HashMap
			HashMap<Integer, String> mapParameterName = new HashMap<Integer, String>();
			for (int iRow = headerRow; iRow <= sheetTestData.getLastRowNum(); iRow++) {
				XSSFRow rowCurrent = sheetTestData.getRow(iRow);
				XSSFCell cellParameterName = rowCurrent.getCell(parameterNameColumnNum);
				String strParameterName = cellParameterName.getStringCellValue();
				if (strParameterName == null || strParameterName.isEmpty()) {
					System.out.println("no parameter name at:" + iRow);
				} else {
					mapParameterName.put(iRow, strParameterName);
				}
			}
			for (int iCol = parameterNameColumnNum + 1; iCol < rowHeader.getLastCellNum(); iCol++) {
				System.out.println(rowHeader.getCell(iCol).getStringCellValue());
				Map<String, Object> map = new HashMap<String, Object>();
				for(Integer iRow: mapParameterName.keySet()) {
//				for (int iRow = headerRow; iRow <= sheetTestData.getLastRowNum(); iRow++) {
					XSSFRow rowCurrent = sheetTestData.getRow(iRow);
					XSSFCell cellCurrent = rowCurrent.getCell(iCol);
//					System.out.println(cellParameterName.getStringCellValue());
					if (cellCurrent.getCellType() == CellType.STRING) {
						map.put(mapParameterName.get(iRow), cellCurrent.getStringCellValue());
					} else if (cellCurrent.getCellType() == CellType.NUMERIC) {
						map.put(mapParameterName.get(iRow), cellCurrent.getNumericCellValue());
					}
				}
				Object[] obj = { map };
				listTestData.add(obj);
			}
			workbook.close();
			excelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listTestData;
	}

}
