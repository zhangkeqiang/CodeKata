package com.agilejerry.bowling;

public class BowlingGame {

	private BowlingFrame[] frames = new BowlingFrame[10];
	private int currentFrameNo;

	public void roll(int i) {
		if (currentFrameNo == 10 && getCurrentFrame().isOver()){
			return;
		}
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
			BowlingFrame frame;
			if (i < 9) {
				 frame = new BowlingFrame(i + 1);
			} else {
				 frame = new TenthFrame(10);
			}
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

	/**
	 * @method getFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年8月2日 下午6:17:37
	 */
	public BowlingFrame getFrame(int i) {
		return frames[i - 1];
	}

}
