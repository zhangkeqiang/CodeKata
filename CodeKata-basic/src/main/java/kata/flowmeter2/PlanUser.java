package kata.flowmeter2;

import java.util.HashMap;

import kata.flowmeter.DataPlan;
import kata.flowmeter.FlowManager;

public class PlanUser {
	DataPlan dataPlan;
	HashMap<String, Integer> mapMonthFlow = new HashMap<String, Integer>();

	public void setPlan(DataPlan plan) {
		dataPlan = plan;

	}

	public DataPlan getPlan() {
		return dataPlan;
	}

	public Integer setFlow(int year, int month, int flow) {
		String yearMonth = FlowManager.getYearMonth(year, month);
		return mapMonthFlow.put(yearMonth, Integer.valueOf(flow));

	}

	public int getRealFlow(int year, int month) {
		String yearMonth = FlowManager.getYearMonth(year, month);
		if (mapMonthFlow.get(yearMonth) == null) {
			return -1;
		}
		return mapMonthFlow.get(yearMonth).intValue();
	}

	public int calculateBillingFlow(int year, int month) {
		IFlowMeter meter = null;
		if (dataPlan.getPlanMode() == DataPlan.CURRENTMONTH) {
			meter = new CurrentMonthMeter2();
		} else if (dataPlan.getPlanMode() == DataPlan.TWOMONTH) {
			meter = new TwoMonthMeter2();
		} else {
			meter = new CurrentMonthMeter2();
		}
		return meter.calculateBillingFlow(this, year, month);

	}

	public int getPlanedFlow() {
		return dataPlan.getThreshold();
	}

	public void clear() {
		mapMonthFlow.clear();
		setPlan(null);

	}

}
