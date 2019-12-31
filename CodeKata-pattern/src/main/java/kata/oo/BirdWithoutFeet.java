package kata.oo;

public class BirdWithoutFeet extends Bird{

	public BirdWithoutFeet() {
		//nothing here
	}

	@Override
	public int countFeet() {
		return 0;
	}
	@Override
	public boolean walk(int m) {
		return false;
	}
}
