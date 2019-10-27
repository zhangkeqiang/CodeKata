package kata.kata12;

public class Ruler {
	
	private int feet;

	public Ruler(int feet) {
		this.feet = feet;
	}

	public int getInch(){
		return feet*12;
	}
}
