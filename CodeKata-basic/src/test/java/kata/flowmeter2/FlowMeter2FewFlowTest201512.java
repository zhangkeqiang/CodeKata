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
public class FlowMeter2FewFlowTest201512 {
	PlanUser user;
	DataPlan plan;
	int realFlow, feeFlow;
	
	@Parameters
    public static Collection<Object[]> prepareData()
    {
        // 测试数据
        Object[][] objects = {{ 200, 0 }, 
        		{ 900, 0 }, 
        		{ 1200, 200 }, 
        		{ 1500, 500 },
        		{ 500, 0 }, 
        		{ 3000, 2000 }, 
        		{ 1000, 0 }, 
        		{ 7000, 6000 }, 
        		{ 0, 0 }};
        		
        return Arrays.asList(objects);// 将数组转换成集合返回

    }
	
	public FlowMeter2FewFlowTest201512(int realFlow, int feeFlow){
		this.realFlow = realFlow;
		this.feeFlow = feeFlow;
	}

	@Before
	public void setUp() throws Exception {
		System.out.println("setUp before");
		user = new PlanUser();
		plan = new DataPlan(1000,30);
		plan.setMode(DataPlan.TWOMONTH);
		user.setPlan(plan);
		initData();
	}

	private void initData() {
		user.setFlow(2015,12,200);
		user.setFlow(2016,1,200);
		user.setFlow(2016,2,200);
	}
	
	
	@After
	public void tearDown() throws Exception {
		plan.clear();
		user.clear();
		System.out.println("tearDown After");
	}

	@Test
	public void testMeter2calcFlow() {
		System.out.println("Run");
		user.setFlow(2016,3,realFlow);
		assertEquals(feeFlow, user.calculateBillingFlow(2016,3));
	}

}
