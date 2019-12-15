package kata.kata12;

public class Ruler {
	private double inch = 0;

	public Ruler() {

	}

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
}
