package kata.flowmeter2;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import kata.flowmeter.DataPlan;

@RunWith(Parameterized.class)
public class FlowMeter2Test {
	PlanUser user;
	DataPlan plan;
	int realFlow, feeFlow, feeFlow2;
	@Parameters
    public static Collection<Object[]> prepareData()
    {
        // 测试数据
        Object[][] objects = {{ 200, 0, 200 }, 
        		{ 900, 400, 900 }, 
        		{ 1200, 700, 1200 }, 
        		{ 1500, 1000, 1500 },
        		{ 500, 0, 500 }, 
        		{ 3000, 2500, 3000 }, 
        		{ 0, 0, 0 }};
        		
        return Arrays.asList(objects);// 将数组转换成集合返回

    }
	
	public FlowMeter2Test(int realFlow, int feeFlow, int feeFlow2){
		this.realFlow = realFlow;
		this.feeFlow = feeFlow;
		this.feeFlow2 =  feeFlow2;
	}

	@Before
	public void setUp() throws Exception {
		user = new PlanUser();
		plan = new DataPlan(1000,30);
		plan.setMode(DataPlan.TWOMONTH);
		user.setPlan(plan);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMeter2calcFlow() {
		user.setFlow(2015,10,900);
		user.setFlow(2015,11,1200);
		user.setFlow(2015,12,500);
		user.setFlow(2016,1,realFlow);
		assertEquals(feeFlow, user.calculateBillingFlow(2016,1));
		
		
		user.setFlow(2015,10,1900);
		user.setFlow(2015,11,1200);
		user.setFlow(2015,12,1500);
		user.setFlow(2016,1,realFlow);
		assertEquals(feeFlow2, user.calculateBillingFlow(2016,1));
	}
}
