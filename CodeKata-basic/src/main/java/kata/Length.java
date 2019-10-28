package kata;

public class Length {
	private double inch =0;
	public Length(double d, String unit) {
		switch(unit){
			case "INCH":
				inch = d;
				break;
			case "FEET":
				inch = d*12;
				break;
			default: 
				inch = d;
		}
	}
	
	public double getInch() {
		return this.inch;
	}
	
	public double getFeet() {
		return this.inch/12;
	}
	
	public double getYard() {
		return this.inch/36;
	}
}
