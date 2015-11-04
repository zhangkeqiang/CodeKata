package kata.flowmeter;

public class DataPlan {
	public static final int CURRENTMONTH = 1;
	int flowThreshold;
	int fee;
	int mode;
	public DataPlan(int threshold, int fee) {
		this.flowThreshold = threshold;
		this.fee = fee;
		
	}
	public int getThreshold() {
		return this.flowThreshold;
	}
	public int getPlanMode() {
		// TODO Auto-generated method stub
		return CURRENTMONTH;
	}

}
