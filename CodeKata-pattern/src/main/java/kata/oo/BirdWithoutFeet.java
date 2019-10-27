package kata.oo;

public class BirdWithoutFeet extends Bird{

	public BirdWithoutFeet() {
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
