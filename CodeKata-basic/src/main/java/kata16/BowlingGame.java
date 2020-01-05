package kata16;

import java.util.ArrayList;

public class BowlingGame {
	private static final int NUM_OF_FRAMECONTAINER = 13;
	ArrayList<BowlingFrame> alFrame = new ArrayList<BowlingFrame>();
	private int currentFrameNum = 0;

	public BowlingGame() {
		for (int i = 0; i < NUM_OF_FRAMECONTAINER; i++) {
			alFrame.add(new BowlingFrame(this, i));
		}
	}

	public BowlingFrame getCurrentFrame() {
		return alFrame.get(currentFrameNum);
	}

	public int getCurrentFrameNum() {
		return (this.currentFrameNum + 1)>10?10:(this.currentFrameNum + 1);
	}

	public BlockResult addBlock(BowlingBlock block) {
		if (!isOver()) {
			BlockResult result = getCurrentFrame().addBlock(block);
			if(isOver()) {
				result.setGameOver();
			}
			if (result.isOver()) {
				currentFrameNum++;
			}
			return result;
		}else {
			return null;
		}
	}

	public boolean isOver() {
		return alFrame.get(9).isScored;
	}

	public int getScore() {
		int score = 0;
		for (int i = 0; i < 10; i++) {
			if (alFrame.get(i).isScored()) {
				score += alFrame.get(i).getScore();
			} else {
				break;
			}
		}
		return score;
	}

	public String getMessage() {
		String message = " Current Frame：No." + getCurrentFrameNum();
		for (int i = 0; i < getCurrentFrameNum(); i++) {
			message += " Frame" + Integer.toString(i + 1) + ":" + alFrame.get(i).getMessage();
		}
		return message;
	}

	public BowlingFrame getFrame(int frameNum) {
		return alFrame.get(frameNum);
	}

}
