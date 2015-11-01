package kata.flowmeter;

import java.util.HashMap;

public class UserFlow {
	DataPlan dataPlan;
	HashMap<String, Integer> mapMonthFlow = new HashMap<String, Integer>();
	public  void setDataPlan(DataPlan plan) {
		this.dataPlan = plan;
		
	}
	public void setFlow(int year, int month, int flow) {
		  
		String yearMonth = FlowManager.getYearMonth(year, month);
		mapMonthFlow.put(yearMonth,Integer.valueOf(flow));
		
	}
	public int getRealFlow(String yearMonth) {
		if(mapMonthFlow.get(yearMonth) == null){
			return -1;
		}
		return mapMonthFlow.get(yearMonth).intValue() ;		
	}
	public int getPlanedFlow() {
		// TODO Auto-generated method stub
		return dataPlan.getThreshold();
	}


}
