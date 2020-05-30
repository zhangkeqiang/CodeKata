package kata16;

import java.util.ArrayList;

public class BowlingMatch {
	private int numberOfBowler;
	ArrayList<Bowler> alBowler = new ArrayList<>(); 
	public void startMatch(int numberOfBowler) {
		this.setNumberOfBowler(numberOfBowler);
	}
	public int getNumberOfBowler() {
		return numberOfBowler;
	}
	public void setNumberOfBowler(int numberOfBowler) {
		this.numberOfBowler = numberOfBowler;
	}
}
