package kata.excel;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ZMExcelTest {

	@SuppressWarnings("rawtypes")
	static Stream<Map> provideExampleList() {
		String filepath = "E:\\VSCode\\SimpleOpen\\ScrumBan\\Excel\\ExcelBDD.xlsx";
		List<Map> list = ZMExcel.getExampleList(filepath, "SimpleOpenBDD", 1, 'D');
		return list.stream();
	}

	@Test
	public final void test() {
		char parameterNameColumn = 'D';
		int parameterNameColumnNum = (int) parameterNameColumn - 64;
		assertEquals(parameterNameColumnNum, 4);
	}

	@ParameterizedTest
	@ValueSource(strings = { "racecar", "radar", "able was I ere I saw elba" })
	void palindromes(String candidate) {
		System.out.println(candidate);
	}

	@ParameterizedTest(name = "#{index} - Test with Map : {0}")
	@MethodSource("provideExampleList")
	void testParameterizedTestByMap(Map<String, Object> mapParams) {
		assertNotNull(mapParams);
		System.out.println("Header " + mapParams.get("Header"));
		System.out.println("SheetName " + mapParams.get("SheetName"));
		System.out.println("HeaderRow " + mapParams.get("HeaderRow"));
		System.out.println("ParameterNameColumn " + mapParams.get("ParameterNameColumn"));
		assertEquals(mapParams.get("Header1Name"), "Scenario1");
		assertEquals(mapParams.get("FirstGridValue"), "V1.1");
		assertEquals(mapParams.get("LastGridValue"), "V4.4");
		assertEquals(mapParams.get("ParamName1InSet2Value"), "V1.2");
		assertEquals(mapParams.get("ParamName2InSet2Value"), "V2.2");
		assertEquals(mapParams.get("ParamName3Value"), null);
		assertTrue(mapParams.get("ParamName3Value") == null, "ParamName3Value");

		assertEquals(mapParams.get("MaxBlankThreshold"), 3.0);
		System.out.println("HeaderMatcher " + mapParams.get("HeaderMatcher"));
		assertEquals(mapParams.get("HeaderMatcher"), "Scenario");
		System.out.println("ParameterCount " + mapParams.get("ParameterCount"));
		assertEquals(mapParams.get("ParameterCount"), 5.0);

		String filepath = "E:\\VSCode\\SimpleOpen\\ScrumBan\\Excel\\ExcelBDD.xlsx";
		int nHeaderRow = ((Double) mapParams.get("HeaderRow")).intValue();
		char charParameterNameColumn = ((String) mapParams.get("ParameterNameColumn")).charAt(0);
		System.out.println("ParameterNameColumn " + charParameterNameColumn);

		@SuppressWarnings("rawtypes")
		List<Map> list = ZMExcel.getExampleList(filepath, (String) mapParams.get("SheetName"), nHeaderRow,
				charParameterNameColumn, (String) mapParams.get("HeaderMatcher"));
		System.out.println(list.get(0).toString());
		System.out.println(list.get(1).toString());
		System.out.println(list.get(2).toString());
		System.out.println(list.get(3).toString());
		
		assertEquals(list.toArray().length, 4);
		assertEquals(list.get(0).get("ParamName1"), "V1.1");
		assertEquals(list.get(1).get("ParamName1"), "V1.2");
		assertEquals(list.get(2).get("ParamName1"), "V1.3");
		assertEquals(list.get(3).get("ParamName1"), "V1.4");
		
		assertEquals(list.get(0).get("ParamName2"), "V2.1");
		assertEquals(list.get(1).get("ParamName2"), "V2.2");
		
		assertEquals(list.get(0).get("ParamName3"), null);
		assertEquals(list.get(1).get("ParamName3"), null);
		assertEquals(list.get(2).get("ParamName3"), null);
		assertEquals(list.get(3).get("ParamName3"), null);
		
		assertEquals(list.get(2).get("ParamName4"), "V4.3");
		assertEquals(list.get(3).get("ParamName4"), "V4.4");
	}
}
