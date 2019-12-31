package kata16;

import java.util.ArrayList;

public class BowlingMatch {
	private int numberOfBowler;
	ArrayList<Bowler> alBowler = new ArrayList<Bowler>(); 
	public void startMatch(int numberOfBowler) {
		this.numberOfBowler = numberOfBowler;
		for(int i=0;i<this.numberOfBowler;i++) {
			alBowler.add(new Bowler());
		}
	}
}
