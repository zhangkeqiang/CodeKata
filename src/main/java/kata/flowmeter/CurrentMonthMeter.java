package kata.flowmeter;

public class CurrentMonthMeter implements FlowMeter {

	public int calculateBillingFlow(UserFlow userFlow, int year, int month) {
		return userFlow.getRealFlow(FlowManager.getYearMonth(year, month));
	}

}
