package kata.flowmeter;

public class CurrentMonthMeter implements FlowMeter {

	@Override
	public int calculateBillingFlow(UserFlow userFlow, int year, int month) {
		return userFlow.getRealFlow(FlowManager.getYearMonth(year, month));
	}

}
