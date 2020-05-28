package kata.kata12;

public class Ruler {
	private double inch = 0;

	public double getInch() {
		return this.inch;
	}

	public void setFeet(double feet) {
		this.inch = feet * 12;
	}

	public void setInch(double inch) {
		this.inch = inch;
	}

	public void setYard(double yard) {
		this.inch = yard * 36;
	}

	public double getFeet() {
		return this.inch / 12;
	}

	public double getYard() {
		return this.inch / 36;
	}
	
	public void setFeet2(double feet) {
		this.inch = feet * 12;
	}
	
	public void setFeet3(double feet) {
		this.inch = feet * 12;
	}
	
	public void setFeet4(double feet) {
		this.inch = feet * 12;
	}
}
