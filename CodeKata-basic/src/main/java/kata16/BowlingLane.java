package kata16;

import java.util.ArrayList;

public class BowlingLane {
	private String message;
	private String state = "INIT";
	


	ArrayList<BowlingMatch> alBowlingMatch = new ArrayList<BowlingMatch>();
	ArrayList<Bowler> alBowler = new ArrayList<Bowler>();
	private int numOfMatch;
	private int numOfBowler;
	private int currentBowlerNo = 0;	
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	public BowlingBlock roll(int pin) {
		if(state.equals("INIT")) {
			message = "The match is not started, please start";
			return null;
		}
		BowlingBlock block = new BowlingBlock(pin);
		getCurrentBowler().addBlock(block);
		message = "got" + pin;
		return block;

	}

	public Bowler getCurrentBowler() {
		return alBowler.get(this.currentBowlerNo);
	}

	public boolean startMatch(int numOfMatch, int numOfBowler) {
		this.numOfMatch = numOfMatch;
		this.numOfBowler = numOfBowler;
		for (int i = 0; i < this.numOfMatch; i++) {
			alBowlingMatch.add(new BowlingMatch());
			alBowlingMatch.get(i).startMatch(this.numOfBowler);
		}
		for (int i = 0; i < this.numOfBowler; i++) {
			alBowler.add(new Bowler(this.numOfMatch));
		}
		message = numOfBowler + "bowler Start " + numOfMatch + " Round. ";
		state = "RUNNING";
		return true;
	}

	public String showMessage() {
		return message + "\r No." + (currentBowlerNo+1) +"'s turn, please";
	}
}
