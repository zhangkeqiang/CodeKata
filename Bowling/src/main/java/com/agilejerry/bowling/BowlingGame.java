package com.agilejerry.bowling;

public class BowlingGame {

	private BowlingFrame[] frames = new BowlingFrame[10];
	private int currentFrameNo;

	public void roll(int i) {
		if (getCurrentFrame().isOver()) {
			currentFrameNo++;
		}
		getCurrentFrame().roll(i);
	}

	/**
	 * @method prepare(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月28日 上午10:27:10
	 */
	public void prepare() {
		for (int i = 0; i < 10; i++) {
			BowlingFrame frame = new BowlingFrame(i+1);
			frame.prepare(10);
			frames[i] = frame;
			if (i > 0) {
				frames[i - 1].setNextFrame(frame);
				frames[i].setPreviousFrame(frames[i - 1]);
			}
		}
		currentFrameNo = 1;

	}

	/**
	 * @method getCurrentFrame(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月28日 上午1frames[currentFrameNo-1]0:28:17
	 */
	public BowlingFrame getCurrentFrame() {
		return frames[currentFrameNo - 1];
	}

}
