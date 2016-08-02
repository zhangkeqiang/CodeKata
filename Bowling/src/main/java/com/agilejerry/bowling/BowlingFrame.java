package com.agilejerry.bowling;

import kata.bowling.BowlingTerm;

public class BowlingFrame {
	protected int currentRollNo = 0;
	protected BowlingRoll[] rolls = new BowlingRoll[3];
	protected int state = BowlingTerm.FRAME_INIT;
	protected int score = BowlingTerm.BLANK;
	protected BowlingFrame nextFrame;
	protected BowlingFrame previousFrame;
	protected int frameNo;

	/**
	 * (这里用一句话描述这个构造函数的作用)
	 * 
	 * @param i
	 */
	public BowlingFrame(int i) {
		this.frameNo = i;
		prepare(10);
	}

	public BowlingFrame getNextFrame() {
		return this.nextFrame;
	}

	public void setNextFrame(BowlingFrame frame) {
		this.nextFrame = frame;
	}

	public BowlingRoll roll(int pins) {
		if(checkExceedMaxPins(pins))
			return null;
		rolls[currentRollNo - 1].setPins(pins);
		int thisRollIndex = currentRollNo - 1;
		showFrameState(pins);
		return rolls[thisRollIndex];
	}

	protected void showFrameState(int pins) {
		if (currentRollNo == 1 && pins < BowlingTerm.STRIKE) {
			this.state = BowlingTerm.FRAME_RUNNING;
			prepare(10 - rolls[0].getPins());
		} else if (currentRollNo == 1 && pins == BowlingTerm.STRIKE) {
			this.state = BowlingTerm.X_STRIKE;
		} else if ((pins + rolls[0].getPins()) < BowlingTerm.STRIKE) {
			this.state = BowlingTerm.FRAME_NORMALOVER;
		} else if ((pins + rolls[0].getPins()) == BowlingTerm.STRIKE) {
			this.state = BowlingTerm.SLASH_SQARE;
		}
	}

	/**
	 * @method prepare(这里用一句话描述这个方法的作用)
	 * @return BowlingRoll
	 * @author Administrator
	 * @date 2016年7月25日 下午11:33:54
	 */
	protected BowlingRoll prepare(int maxPins) {
		BowlingRoll roll = new BowlingRoll(maxPins);
		rolls[currentRollNo++] = roll;
		return roll;
	}

	/**
	 * @method getPins(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月27日 上午8:26:29
	 */
	public BowlingRoll getRoll(int i) {
		return rolls[i - 1];
	}
	
	protected boolean checkExceedMaxPins(int pins) {
		return (pins > rolls[currentRollNo - 1].getMaxPins());
	}

	/**
	 * @method getState(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月28日 上午10:03:43
	 */
	public int getState() {
		return this.state;
	}

	/**
	 * @method isOver(这里用一句话描述这个方法的作用)
	 * @return boolean
	 * @author Administrator
	 * @date 2016年7月28日 上午10:55:36
	 */
	public boolean isOver() {
		if (state == BowlingTerm.FRAME_RUNNING || state == BowlingTerm.FRAME_INIT)
			return false;
		else
			return true;
	}

	/**
	 * @method getScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月28日 上午11:33:52
	 */
	public int getScore() {
		if (score == BowlingTerm.BLANK && isOver()) {
			return calculateScore();
		}
		return score;

	}

	/**
	 * @method calculateScore(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月29日 上午9:33:25
	 */
	protected int calculateScore() {
		switch (state) {
		case BowlingTerm.FRAME_RUNNING:
			return BowlingTerm.BLANK;
		case BowlingTerm.FRAME_NORMALOVER:
			if (this.frameNo > 1)
				score = this.previousFrame.getScore() + rolls[0].getPins() + rolls[1].getPins();
			else
				score = rolls[0].getPins() + rolls[1].getPins();
			break;
		case BowlingTerm.SLASH_SQARE:
			if (nextFrame.getState() != BowlingTerm.FRAME_INIT) {
				if (this.frameNo > 1)
					score = this.previousFrame.getScore() + 10 + nextFrame.getRoll(1).getPins();
				else
					score = 10 + nextFrame.getRoll(1).getPins();
			}
			break;
		case BowlingTerm.X_STRIKE:
			calculateNextTwoRoll();
		}

		return score;
	}

	protected void calculateNextTwoRoll() {
		if (this.frameNo < 9) {
			if (nextFrame.getState() == BowlingTerm.X_STRIKE) {
				if (nextFrame.getNextFrame().getState() != BowlingTerm.FRAME_INIT) {
					if (this.frameNo > 1)
						score = this.previousFrame.getScore() + 20 + nextFrame.getNextFrame().getRoll(1).getPins();
					else
						score = 20 + nextFrame.getNextFrame().getRoll(1).getPins();
				}
			}
		} else {
			if (nextFrame.getRoll(2) != null && nextFrame.getRoll(2).getPins() != BowlingTerm.BLANK) {
				score = this.previousFrame.getScore() + 10 + nextFrame.getRoll(1).getPins()
						+ nextFrame.getRoll(2).getPins();
			}
		}

	}

	/**
	 * @method previousFrame(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月29日 上午9:17:17
	 */
	public BowlingFrame previousFrame() {
		return this.previousFrame;
	}

	/**
	 * @method setPreviousFrame(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月29日 上午9:30:38
	 */
	public void setPreviousFrame(BowlingFrame bowlingFrame) {
		this.previousFrame = bowlingFrame;
	}

	/**
	 * @method getFrameNo(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月29日 上午10:12:04
	 */
	public int getFrameNo() {
		return this.frameNo;
	}

}
