package kata.excel;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import kata.flowmeter.DataPlan;

@RunWith(Parameterized.class)
public class ZMExcelParameterizedTest {
	
	Map mapParams;
	
	@Parameters
    public static Collection<Object[]> prepareData()
    {
    	String filepath = "src/test/java/kata/excel/ExcelBDD.xlsx";
    	return ZMExcel.getExampleCollection(filepath, "SimpleOpenBDD", 1, 'D');
    }
	
	public ZMExcelParameterizedTest(Map map){
		this.mapParams = map;
	}


	@Test
	public void testMeter2calcFlow() {
		
		System.out.println("Header " + mapParams.get("Header"));
		System.out.println("SheetName " + mapParams.get("SheetName"));
		System.out.println("HeaderRow " + mapParams.get("HeaderRow"));

		System.out.println(mapParams.get("MaxBlankThreshold"));
		System.out.println(mapParams.get("HeaderMatcher"));
		System.out.println(mapParams.get("ParameterCount"));		
		System.out.println("ParameterNameColumn " + mapParams.get("ParameterNameColumn"));
		
		assertEquals("Scenario1", mapParams.get("Header1Name"));
		assertEquals("V1.1", mapParams.get("FirstGridValue"));
		assertEquals("4.4", mapParams.get("LastGridValue"));
		assertEquals("V1.2", mapParams.get("ParamName1InSet2Value"));
		assertEquals("V2.2", mapParams.get("ParamName2InSet2Value"));
		assertEquals("", mapParams.get("ParamName3Value"));
	}
}
