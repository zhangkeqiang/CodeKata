package kata.flowmeter;

public class DataPlan {
	int flowThreshold;
	int fee;
	public DataPlan(int threshold, int fee) {
		this.flowThreshold = threshold;
		this.fee = fee;
		
	}
	public int getThreshold() {
		return this.flowThreshold;
	}

}
