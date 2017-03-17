package kata.flowmeter2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import kata.flowmeter.DataPlan;

@RunWith(Parameterized.class)
public class FlowMeter2FewFlowTest2 {
    PlanUser user;
    DataPlan plan;

    @Parameters
    public static Collection<Object[]> prepareData() {
        // 测试数据
        Object[][] objects = {
                {
                        200, 0 },
                {
                        900, 0 },
                {
                        1200, 200 },
                {
                        1500, 500 },
                {
                        500, 0 },
                {
                        3000, 2000 },
                {
                        0, 0 },
                {
                        4000, 3000 }, };

        return Arrays.asList(objects);// 将数组转换成集合返回

    }

    @Parameter // first data value (0) is default /* NOT private */
    public int realFlow;
    @Parameter(1)
    public int feeFlow;

    @Before
    public void setUp() throws Exception {
        System.out.println("SetUp");
        user = new PlanUser();
        plan = new DataPlan(1000, 30);
        plan.setMode(DataPlan.TWOMONTH);
        user.setPlan(plan);
        user.setFlow(2015, 10, 200);
        user.setFlow(2015, 11, 200);
        user.setFlow(2015, 12, 200);
    }

    @Test
    public void testMeter2calcFlow() {
        System.out.println("testMeter2calcFlow");
        user.setFlow(2016, 1, realFlow);
        assertEquals(feeFlow, user.calculateBillingFlow(2016, 1));
    }

    @Test
    public void testMeter2calcFlowanother() {
        System.out.println("testMeter2calcFlowanother");
        user.setFlow(2016, 1, realFlow);
        assertEquals(feeFlow, user.calculateBillingFlow(2016, 1));
    }
}
