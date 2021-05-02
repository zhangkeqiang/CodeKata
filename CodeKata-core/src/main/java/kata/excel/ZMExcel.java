package kata.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ZMExcel {

	@SuppressWarnings("rawtypes")
	public static List<Map> getExampleList(String excelPath, String worksheetName) {
		return getExampleList(excelPath, worksheetName, 1, 'C', ".*");
	}

	@SuppressWarnings("rawtypes")
	public static List<Map> getExampleList(String excelPath, String worksheetName, int headerRow,
			char parameterNameColumn) {
		return getExampleList(excelPath, worksheetName, headerRow, parameterNameColumn, ".*");
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static List<Map> getExampleList(String excelPath, String worksheetName, int headerRow,
			char parameterNameColumn, String headerMatcher) {
		String strRealHeaderMatcher = ".*" + headerMatcher + ".*";
		ArrayList<Map> listTestSet = new ArrayList<Map>();
		try {
			int parameterNameColumnNum = (int) parameterNameColumn - 65;
			System.out.println("parameterNameColumnNum:" + parameterNameColumnNum);

			FileInputStream excelFile = new FileInputStream(new File(excelPath));
			XSSFWorkbook workbook = new XSSFWorkbook(excelFile);
			XSSFSheet sheetTestData = workbook.getSheet(worksheetName);
			System.out.println("RowSum:" + sheetTestData.getLastRowNum());
			XSSFRow rowHeader = sheetTestData.getRow(headerRow - 1);

			// Get Matched Column HashMap
			System.out.println("Column Sum:" + rowHeader.getLastCellNum());
			int nMaxColumn = rowHeader.getLastCellNum();
			HashMap<Integer, String> mapTestDataHeader = new HashMap<Integer, String>();
			for (int iCol = parameterNameColumnNum + 1; iCol < nMaxColumn; iCol++) {
				XSSFCell cellHeader = rowHeader.getCell(iCol);
				if (cellHeader.getStringCellValue().matches(strRealHeaderMatcher)) {
					mapTestDataHeader.put(iCol, cellHeader.getStringCellValue());
					Map<String, Object> mapTestSet = new HashMap<String, Object>();
					mapTestSet.put("Header", cellHeader.getStringCellValue());
					listTestSet.add(mapTestSet);
				}
			}
			// Get ParameterNames HashMap
			HashMap<Integer, String> mapParameterName = new HashMap<Integer, String>();
			System.out.println("getLastRowNum " + sheetTestData.getLastRowNum());
			int nContinuousBlankCount = 0;
			for (int iRow = headerRow; iRow <= sheetTestData.getLastRowNum(); iRow++) {
				if (nContinuousBlankCount > 3) {
					break;
				}
				System.out.println("Check Row " + iRow);
				XSSFRow rowCurrent = sheetTestData.getRow(iRow);
				if (rowCurrent == null) {
					System.out.println("no row  ParameterName name at:" + iRow);
					nContinuousBlankCount++;
					System.out.println("nContinuousBlankCount " + nContinuousBlankCount);
					continue;
				}
				XSSFCell cellParameterName = rowCurrent.getCell(parameterNameColumnNum);
				if (cellParameterName == null) {
					System.out.println("no cell ParameterName name at:" + iRow);
					nContinuousBlankCount++;
					System.out.println("nContinuousBlankCount " + nContinuousBlankCount);
					continue;
				}
				String strParameterName = cellParameterName.getStringCellValue();
				if (strParameterName == null || strParameterName.isEmpty()) {
					System.out.println("no parameter name at:" + iRow);
					nContinuousBlankCount++;
					System.out.println("nContinuousBlankCount " + nContinuousBlankCount);
				} else {
					mapParameterName.put(iRow, strParameterName);
					nContinuousBlankCount = 0;
				}
			}

			for (Map.Entry aParameterName : mapParameterName.entrySet()) {
				int iRow = (int) aParameterName.getKey();
				XSSFRow rowCurrent = sheetTestData.getRow(iRow);
				int nPos = 0;
				for (Integer iCol : mapTestDataHeader.keySet()) {
					Map<String, Object> mapTestSet = listTestSet.get(nPos++);
					XSSFCell cellCurrent = rowCurrent.getCell(iCol);
					if (cellCurrent.getCellType() == CellType.STRING) {
						mapTestSet.put((String) aParameterName.getValue(), cellCurrent.getStringCellValue());
					} else if (cellCurrent.getCellType() == CellType.NUMERIC) {
						mapTestSet.put((String) aParameterName.getValue(), cellCurrent.getNumericCellValue());
					}
				}
			}
			workbook.close();
			excelFile.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return listTestSet;
	}

	public static Collection<Object[]> getExampleCollection(String excelPath, String worksheetName, int headerRow,
			char parameterNameColumn) {
		Collection<Object[]> collectionTestData = new ArrayList<Object[]>();
		List<Map> listTestData = getExampleList(excelPath, worksheetName, headerRow, parameterNameColumn);
		for (Map map : listTestData) {
			Object[] arrayObj = { map };
			collectionTestData.add(arrayObj);
		}
		return collectionTestData;
	}

}
