package kata16;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.Message;

public class BowlingFrame {
	protected Logger logger = LogManager.getLogger();
	private static final String STRIKE = "STRIKE";
	private String state = "INIT";
	private int currentBlockNum = 0;
	int score = 0;
	boolean isScored = false;

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
		sbMessage.append("|Score:" + this.tryGetScore());
		// String resultOfTryScore = tryGetScore();
		// if (resultOfTryScore.equals("SCORED")) {
		// sbMessage.append("|Score:" + this.getScore());
		// } else if (resultOfTryScore.equals("SPAREWAITING")) {
		// sbMessage.append("|Score:SPARE");
		// }
		return sbMessage.toString();
	}

	private String tryGetScore() {
		if (state.equals("INIT") || state.equals("FIRSTBLOCK")) {
			return "NOTREADY";
		}
		if (isScored) {
			return Integer.toString(score);
		}
		score = 0;
		for (int i = 0; i < alBlock.size(); i++) {
			score = score + alBlock.get(i).getPin();
			logger.debug(score);
		}
		if (score < 10) {
			isScored = true;
		} else if (isStrike()) {
			if (hasNext2Blocks()) {
				score += getNext2BlockScore();
			} else {

			}
		} else if (isSpare()) {
			if (hasNextBlock()) {
				score += getNextBlockScore();
				isScored = true;
			} else {
				return "SPAREWAITING";
			}
		}

		return Integer.toString(score);
	}

	private boolean hasNextBlock() {
		logger.debug(frameNum);
		BowlingFrame nextFrame = game.getFrame(frameNum + 1);
		logger.debug(nextFrame.getFrameNum());
		logger.debug(nextFrame.getState());
		return !nextFrame.getState().equals("INIT");
	}

	private int getFrameNum() {
		return this.frameNum;
	}

	private boolean hasNext2Blocks() {
		// TODO Auto-generated method stub
		return false;
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

	private int getNext2BlockScore() {
		BowlingBlock nextBlock = this.game.getFrame(frameNum + 1).getFirstBlock();
		if (nextBlock.getPin() < 10) {
			return 0;
		}
		return 0;
	}

}
