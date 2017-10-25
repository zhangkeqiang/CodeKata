package kata.flowmeter;

public class FlowManager {
	public static final int ONEMONTH = 1;
	public static final int CURRENTMONTH = ONEMONTH;
	public static final int TWOMONTH = 2;
	private int billMode = TWOMONTH;
	private FlowMeter meter;
	public static String getYearMonth(int year, int month) {
		String yearMonth;
		if(month < 1){
			yearMonth = String.valueOf(year-1);
			month = 12+month;
		}else if(month < 13){
		    yearMonth = String.valueOf(year);
		}else {
			yearMonth = String.valueOf(year+1);
			month = month -12;
		}
		if (month < 10) {
			yearMonth += "0" + String.valueOf(month);
		} else {
			yearMonth += String.valueOf(month);
		}
		return yearMonth;
	}

	private FlowMeter getMeter(){
		if(meter == null){
			if(this.billMode == CURRENTMONTH) {
				meter = new CurrentMonthMeter();
			}else if(this.billMode == TWOMONTH){
				meter = new TwoMonthMeter();
			}
		}
		return meter;
	}
	public int calculateBillingFlow(UserFlow userFlow, int year, int month) {
		return getMeter().calculateBillingFlow(userFlow, year, month);
	}
	
	public void setMode(int mode) {
		this.billMode = mode;
	}

}
