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
public class FlowMeter2OverLimitTest {
	PlanUser user;
	DataPlan plan;
	int realFlow, feeFlow;
	@Parameters
    public static Collection<Object[]> prepareData()
    {
        // 测试数据
        Object[][] objects = {{ 200, 200 }, 
        		{ 900, 900 }, 
        		{ 1200, 1200 }, 
        		{ 1500, 1500 },
        		{ 500, 500 }, 
        		{ 3000, 3000 }, 
        		{ 0, 0 }};
        		
        return Arrays.asList(objects);// 将数组转换成集合返回

    }
	
	public FlowMeter2OverLimitTest(int realFlow, int feeFlow){
		this.realFlow = realFlow;
		this.feeFlow = feeFlow;
	}

	@Before
	public void setUp() throws Exception {
		user = new PlanUser();
		plan = new DataPlan(1000,30);
		plan.setMode(DataPlan.TWOMONTH);
		user.setPlan(plan);
		user.setFlow(2015,10,1200);
		user.setFlow(2015,11,1200);
		user.setFlow(2015,12,1500);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testMeter2calcFlow() {
		user.setFlow(2016,1,realFlow);
		assertEquals(feeFlow, user.calculateBillingFlow(2016,1));
	}

}
