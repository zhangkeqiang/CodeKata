package kata.flowmeter;

public class TwoMonthMeter implements FlowMeter {

	@Override
	public int calculateBillingFlow(UserFlow userFlow, int year, int month) {
		int billingFlow=0;
		int last2RealFlow = userFlow.getRealFlow(FlowManager.getYearMonth(year, month - 2));
		int lastRealFlow = userFlow.getRealFlow(FlowManager.getYearMonth(year, month - 1));
		int realFlow = userFlow.getRealFlow(FlowManager.getYearMonth(year, month));
		if (last2RealFlow < 0 || last2RealFlow > userFlow.getPlanedFlow()) {			
			if (lastRealFlow < 0 || lastRealFlow > userFlow.getPlanedFlow()) {
				billingFlow = realFlow;
			}else{
				billingFlow = realFlow - (userFlow.getPlanedFlow() - lastRealFlow);
			}
		}else{
			if((lastRealFlow - (userFlow.getPlanedFlow() - last2RealFlow)) > userFlow.getPlanedFlow()){
				billingFlow = realFlow;
			}else{
				if((last2RealFlow + lastRealFlow) > userFlow.getPlanedFlow()){
					billingFlow = realFlow - 2*userFlow.getPlanedFlow() + last2RealFlow + lastRealFlow;
				}else{
					billingFlow = realFlow - userFlow.getPlanedFlow();
				}
					
			}
			
		}
		if(billingFlow < 0) billingFlow = 0;
		return billingFlow;
	}

}
