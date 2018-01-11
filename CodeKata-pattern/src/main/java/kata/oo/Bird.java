package kata.oo;

public class Bird {

	protected static final int WINGS_OF_BIRD = 2;
	protected static final int FEET_OF_BIRD = 2;
	protected int flyDistance = 0;
	protected int walkDistance = 0;
	protected String url;
	public Bird() {
	}

	public boolean fly(int m) {
		flyDistance += m;
		return true;
	}

	public boolean walk(int m) {
		walkDistance += m;
		return true;
	}

	public int countWings() {
		return WINGS_OF_BIRD;
	}

	public int countFeet() {
		return FEET_OF_BIRD;
	}

	public int getFlyDistance() {
		return this.flyDistance;
	}

	public int getDistance() {
		return this.flyDistance + this.walkDistance;
	}

	public String getURL() {
		return url;
	}

}
