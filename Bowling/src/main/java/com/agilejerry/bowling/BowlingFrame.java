package com.agilejerry.bowling;

import kata.bowling.BowlingTerm;

public class BowlingFrame {
	private int currentRollNo = 0;
	private BowlingRoll[] rolls = new BowlingRoll[3];
	private int state = BowlingTerm.FRAME_INIT;
	private int score = BowlingTerm.BLANK;
	private BowlingFrame nextFrame;
	private BowlingFrame previousFrame;
	private int frameNo;

	/**(这里用一句话描述这个构造函数的作用)
	 * @param i
	 */
	public BowlingFrame(int i) {
		this.frameNo = i;
	}

	public BowlingFrame nextFrame() {
		return this.nextFrame;
	}

	public void setNextFrame(BowlingFrame frame){
		this.nextFrame = frame;
	}
	/**@method roll(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月25日 下午11:28:59
	*/
	public BowlingRoll roll(int pins) {
		rolls[currentRollNo-1].setPins(pins);
		int thisRollIndex = currentRollNo-1;
		if(currentRollNo == 1 && pins < BowlingTerm.STRIKE){
			this.state = BowlingTerm.FRAME_RUNNING;
			prepare(10-rolls[0].getPins());
		} else if(currentRollNo == 1 && pins == BowlingTerm.STRIKE){
			this.state = BowlingTerm.X_STRIKE;
		} else if((pins + rolls[0].getPins()) < BowlingTerm.STRIKE){
			this.state = BowlingTerm.FRAME_NORMALOVER;
		}else if((pins + rolls[0].getPins()) == BowlingTerm.STRIKE){
			this.state = BowlingTerm.SLASH_SQARE;
		}
		return rolls[thisRollIndex];
	}

	/**@method prepare(这里用一句话描述这个方法的作用)
	 * @return BowlingRoll
	 * @author Administrator
	 * @date 2016年7月25日 下午11:33:54
	*/
	public BowlingRoll prepare(int maxPins) {
		if(currentRollNo ==2)
			return rolls[1];
		BowlingRoll roll = new BowlingRoll(maxPins);
		rolls[currentRollNo++] = roll;
		return roll;
	}

	/**@method getPins(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月27日 上午8:26:29
	*/
	public BowlingRoll getPins(int i) {
		return rolls[i-1];
	}

	/**@method getState(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月28日 上午10:03:43
	*/
	public int getState() {
		return this.state;
	}

	/**@method isOver(这里用一句话描述这个方法的作用)
	 * @return boolean
	 * @author Administrator
	 * @date 2016年7月28日 上午10:55:36
	*/
	public boolean isOver() {
		if(state == BowlingTerm.FRAME_RUNNING || state == BowlingTerm.FRAME_INIT)
			return false;
		else
			return true;
	}

	/**@method getScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月28日 上午11:33:52
	*/
	public int getScore() {
		if(score == BowlingTerm.BLANK){
			return calculateScore();
		}
		return score;
		
	}

	/**@method calculateScore(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月29日 上午9:33:25
	*/
	private int calculateScore() {
		if(state == BowlingTerm.FRAME_RUNNING)
			return BowlingTerm.BLANK;
		if(state == BowlingTerm.FRAME_NORMALOVER){
			if(this.frameNo > 1)
				score = this.previousFrame.getScore() + rolls[0].getPins() + rolls[1].getPins();
			else
				score = rolls[0].getPins() + rolls[1].getPins();
		}
		return score;
	}

	/**@method previousFrame(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月29日 上午9:17:17
	*/
	public BowlingFrame previousFrame() {
		return this.previousFrame;
	}

	/**@method setPreviousFrame(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月29日 上午9:30:38
	*/
	public void setPreviousFrame(BowlingFrame bowlingFrame) {
		this.previousFrame = bowlingFrame;
	}

	/**@method getFrameNo(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月29日 上午10:12:04
	*/
	public int getFrameNo() {
		return this.frameNo;
	}



}
