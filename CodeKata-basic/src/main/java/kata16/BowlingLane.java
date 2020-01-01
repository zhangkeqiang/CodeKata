package kata16;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BowlingLane {
	protected Logger logger = LogManager.getLogger();
	private String message;
	private String state = "INIT";

	ArrayList<BowlingMatch> alBowlingMatch = new ArrayList<BowlingMatch>();
	ArrayList<Bowler> alBowler = new ArrayList<Bowler>();
	private int numOfMatch;
	private int numOfBowler;
	private int currentBowlerNum = 0;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BlockResult roll(int pin) {
		if (state.equals("INIT")) {
			message = "The match is not started, please start";
			return null;
		}
		BowlingBlock block = new BowlingBlock(pin);
		BlockResult result = getCurrentBowler().addBlock(block);
		if (result.isOver()) {
			nextTurn();
		}
		message = result.getMessage();
		logger.info(this.showTotalMessage());
		return result;

	}

	private void nextTurn() {
		if (currentBowlerNum == (numOfBowler - 1)) {
			currentBowlerNum = 0;
		} else {
			currentBowlerNum++;
		}
	}

	public Bowler getCurrentBowler() {
		return alBowler.get(this.currentBowlerNum);
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

	public String showTotalMessage() {
		return "\r" + message + "\r" + showScores() + showBowlerTurn();
	}

	private String showScores() {
		StringBuilder sbMessage = new StringBuilder();
		int i = 0;
		for (Bowler bowler : alBowler) {
			i++;
			sbMessage.append("No." +i+ "Bowler:"+bowler.getMessage() + "\r");
		}
		return sbMessage.toString();
	}

	private String showBowlerTurn() {
		if (this.state.equals("INIT")) {
			return "please First Bowler start the match";
		} else {
			return "No." + (currentBowlerNum + 1) + "'s turn, please roll in Frame"
					+ getCurrentBowler().getCurrentGame().getCurrentFrameNum();
		}
	}

	public int getCurrentBowlerNum() {
		return this.currentBowlerNum + 1;
	}
}
