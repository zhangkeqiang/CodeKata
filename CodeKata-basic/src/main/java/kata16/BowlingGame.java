package kata16;

import java.util.ArrayList;

public class BowlingGame {
	private final int NUM_OF_FRAME = 10;
	ArrayList<BowlingFrame> alFrame = new ArrayList<BowlingFrame>();
	private int currentFrameNum = 0;

	public BowlingGame() {
		for (int i = 0; i < NUM_OF_FRAME; i++) {
			alFrame.add(new BowlingFrame(this, i));
		}
	}

	public BowlingFrame getCurrentFrame() {
		return alFrame.get(currentFrameNum);
	}

	public int getCurrentFrameNum() {
		return this.currentFrameNum + 1;
	}

	public BlockResult addBlock(BowlingBlock block) {
		BlockResult result = getCurrentFrame().addBlock(block);
		if (result.isOver()) {
			currentFrameNum++;
		}
		return result;
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
