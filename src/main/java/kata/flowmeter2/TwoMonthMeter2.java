package kata.flowmeter2;

public class TwoMonthMeter2 implements IFlowMeter {

    public int calculateBillingFlow(PlanUser user, int year, int month) {
        int billingFlow;
        int last2RealFlow = user.getRealFlow(year, month - 2);
        int lastRealFlow = user.getRealFlow(year, month - 1);
        int realFlow = user.getRealFlow(year, month);
        if (last2RealFlow < 0 || last2RealFlow > user.getPlanedFlow()) {            
            if (lastRealFlow < 0 || lastRealFlow > user.getPlanedFlow()) {
                billingFlow = realFlow;
            }else{
                billingFlow = realFlow - (user.getPlanedFlow() - lastRealFlow);
            }
        }else{
            if((lastRealFlow - (user.getPlanedFlow() - last2RealFlow)) > user.getPlanedFlow()){
                billingFlow = realFlow;
            }else{
                if((last2RealFlow + lastRealFlow) > user.getPlanedFlow()){
                    billingFlow = realFlow - 2*user.getPlanedFlow() + last2RealFlow + lastRealFlow;
                }else{
                    billingFlow = realFlow - user.getPlanedFlow();
                }
            }
            
        }
        if(billingFlow < 0) {
            billingFlow = 0;
        }
        return billingFlow;
    }

}
