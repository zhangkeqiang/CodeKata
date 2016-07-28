package com.agilejerry.bowling;

import kata.bowling.BowlingTerm;

public class BowlingFrame {

	private int currentRollNo = 0;
	private BowlingRoll[] rolls = new BowlingRoll[3];
	private int state;
	/**@method nextFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年7月25日 下午11:25:10
	*/
	public BowlingFrame nextFrame() {
		// TODO Auto-generated method stub
		return null;
	}

	/**@method roll(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月25日 下午11:28:59
	*/
	public BowlingRoll roll(int pins) {
		rolls[currentRollNo-1].setPins(pins);
		if(currentRollNo == 1 && pins < BowlingTerm.STRIKE){
			this.state = BowlingTerm.FRAME_RUNNING;
		} else if(currentRollNo == 1 && pins == BowlingTerm.STRIKE){
			this.state = BowlingTerm.X_STRIKE;
		} else if((pins + rolls[0].getPins()) < BowlingTerm.STRIKE){
			this.state = BowlingTerm.FRAME_NORMALOVER;
		}else if((pins + rolls[0].getPins()) == BowlingTerm.STRIKE){
			this.state = BowlingTerm.SLASH_SQARE;
		}
		return rolls[currentRollNo-1];
	}

	/**@method prepare(这里用一句话描述这个方法的作用)
	 * @return BowlingRoll
	 * @author Administrator
	 * @date 2016年7月25日 下午11:33:54
	*/
	public BowlingRoll prepare(int maxPins) {
		BowlingRoll roll = new BowlingRoll(maxPins);
		rolls[currentRollNo++] = roll;
		//this.state = 
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

}
