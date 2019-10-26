package kata;

public class Length {
	private int inch =0;
	public Length(int i, String unit) {
		switch(unit){
			case "INCH":
				inch = i;
				break;
			case "FEET":
				inch = i*12;
				break;
		}
	}
	
	public int getInch() {
		return this.inch;
	}
}
