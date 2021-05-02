package kata.excel;

import static org.junit.Assert.*;

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
    	String filepath = "E:\\VSCode\\SimpleOpen\\ScrumBan\\Excel\\ExcelBDD.xlsx";
    	return ZMExcel.getExampleCollection(filepath, "SimpleOpenBDD", 1, 'D');
    }
	
	public ZMExcelParameterizedTest(Map map){
		this.mapParams = map;
	}


	@Test
	public void testMeter2calcFlow() {
		System.out.println(mapParams.get("SheetName"));
		System.out.println(mapParams.get("FirstGridValue"));
		System.out.println(mapParams.get("MaxBlankThreshold"));
		System.out.println(mapParams.get("HeaderMatcher"));
		System.out.println(mapParams.get("ParameterCount"));
	}
}
