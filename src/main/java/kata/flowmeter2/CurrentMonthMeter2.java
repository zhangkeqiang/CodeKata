package kata.flowmeter2;

public class CurrentMonthMeter2 implements IFlowMeter {

	public int calculateBillingFlow(PlanUser userFlow, int year, int month) {
		return userFlow.getRealFlow(year, month);
	}

}
