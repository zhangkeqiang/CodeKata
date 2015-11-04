package kata.flowmeter;

public class DataPlan {
	public static final int CURRENTMONTH = 1;
	public static final int TWOMONTH = 2;
	int flowThreshold;
	int fee;
	int mode;
	public DataPlan(int threshold, int fee) {
		this.flowThreshold = threshold;
		this.fee = fee;
		mode = CURRENTMONTH;
		
	}
	public int getThreshold() {
		return this.flowThreshold;
	}
	public int getPlanMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	
	

}
