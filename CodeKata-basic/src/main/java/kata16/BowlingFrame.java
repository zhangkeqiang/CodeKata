package kata16;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BowlingFrame {
	protected Logger logger = LogManager.getLogger();
	private static final String STRIKE = "STRIKE";
	private String state = "INIT";
	private int currentBlockNum = 0;
	int score = 0;
	boolean isScored = false;

	public boolean isScored() {
		return isScored;
	}

	public int getCurrentBlockNum() {
		return currentBlockNum + 1;
	}

	private ArrayList<BowlingBlock> alBlock = new ArrayList<BowlingBlock>();
	private BowlingGame game;
	private int frameNum;

	public BowlingFrame(BowlingGame game, int frameNum) {
		this.game = game;
		this.frameNum = frameNum;
	}

	public BowlingBlock getCurrentBlock() {
		return alBlock.get(currentBlockNum);
	}

	public BlockResult addBlock(BowlingBlock block) {
		BlockResult result;
		alBlock.add(block);
		if (block.getPin() == 10 && currentBlockNum == 0) {
			state = STRIKE;
		} else if (currentBlockNum == 0) {
			state = "FIRSTBLOCK";
		} else if (currentBlockNum == 1) {
			if ((alBlock.get(0).getPin() + block.getPin()) == 10) {
				state = "SPARE";
			} else {
				state = "SECONDBLOCK";
			}
		} else {
			state = "ERROR";
		}
		game.getFrame(9).tryGetScore();
		result = new BlockResult(block, state);
		currentBlockNum++;
		return result;
	}

	public String getState() {
		return this.state;
	}

	public String getMessage() {
		StringBuilder sbMessage = new StringBuilder();
		for (int i = 0; i < currentBlockNum; i++) {
			if (i > 0) {
				sbMessage.append(",");
			}
			sbMessage.append(alBlock.get(i).getPin());
		}
		sbMessage.append("|" + this.tryGetScore());
		return sbMessage.toString();
	}

	private String tryGetScore() {
		if (state.equals("INIT") || state.equals("FIRSTBLOCK")) {
			return "NOTREADY";
		}
		if (isScored) {
			return Integer.toString(score);
		}
		if (isStrike()) {
			return tryGetScoreWhenStrike();
		}
		if (isSpare()) {
			return tryGetScoreWhenSpare();
		}
		//Second block is over, no Spare, no Strike
		score = 0;
		for (int i = 0; i < alBlock.size(); i++) {
			score = score + alBlock.get(i).getPin();
		}
		isScored = true;
		return Integer.toString(score);
	}

	private String tryGetScoreWhenSpare() {
		if (hasNextBlock()) {
			score = 10 + getNextBlockScore();
			isScored = true;
			return Integer.toString(score);
		} else {
			return "SPAREWAITING";
		}
	}

	private boolean hasNextBlock() {
		BowlingFrame nextFrame = game.getFrame(frameNum + 1);
		return !nextFrame.getState().equals("INIT");
	}

	private String tryGetScoreWhenStrike() {
		isScored = true;
		BowlingFrame nextFrame = game.getFrame(frameNum + 1);
		if (nextFrame.getState().equals("SPARE")) {
			score = 20;
		} else if (nextFrame.getState().equals("SECONDBLOCK")) {
			score = nextFrame.getFirstBlock().getPin() + nextFrame.getSecondBlock().getPin();
		} else if (nextFrame.getState().equals("STRIKE")) {
			if (nextFrame.hasNextBlock()) {
				score = 20 + game.getFrame(frameNum + 2).getFirstBlock().getPin();
			} else {
				isScored = false;
				return "Double Strikes,Waiting";
			}
		} else {
			isScored = false;
			return "Waiting";
		}
		return Integer.toString(score);
	}

	private BowlingBlock getSecondBlock() {
		return this.alBlock.get(1);
	}

	public boolean isStrike() {
		return state.equals(STRIKE);
	}

	public boolean isSpare() {
		return state.equals("SPARE");
	}

	private int getNextBlockScore() {
		return this.game.getFrame(frameNum + 1).getFirstBlock().getPin();
	}

	private BowlingBlock getFirstBlock() {
		return this.alBlock.get(0);
	}

	public int getScore() {
		return this.score;
	}

}
