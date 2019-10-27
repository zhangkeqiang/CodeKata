package kata.kata12;

public class Ruler {
	private int inch;

	public Ruler(int feet) {
		this.inch = feet * 12;
	}
	
	public int getInch() {
		return this.inch;
	}

}
