package kata.bowling;

/**@ClassName: Frame
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月23日 下午6:04:07 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class Frame {


	private int frameNo;
	private int firstScore = BowlingTerm.BLANK;
	private int secondScore = BowlingTerm.BLANK;

	/**
	 * @param frameNo No. of Frame
	 */
	public Frame(int frameNo) {
		this.frameNo = frameNo;
	}

	/**
	 * @date 2016年7月23日 下午6:08:01
	*/
	public int getNo() {
		return this.frameNo;
	}

	/**@method getFirstScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月23日 下午6:09:34
	*/
	public int getFirstScore() {
		return this.firstScore;
	}

	/**@method getSecondScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月23日 下午6:10:11
	*/
	public int getSecondScore() {
		return this.secondScore;
	}

	/**@method getTotalScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月23日 下午6:11:57
	*/
	public int getTotalScore() {
		if(firstScore == BowlingTerm.STRIKE){
			return BowlingTerm.X_STRIKE;
		}
		if(firstScore < 0 || secondScore < 0){
			return BowlingTerm.BLANK;
		}
		return (firstScore + secondScore) == 10 ? BowlingTerm.SLASH_SQARE: (firstScore + secondScore);
		
	}

	public void deliver(int sequence, int pins) {
		if(sequence == 1){
			this.firstScore = pins;
		}else if(sequence == 2){
			this.secondScore = pins;
		}
	}

	/**@method setFirstScore(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午12:19:25
	*/
	public void setFirstScore(int pins) {
		this.firstScore = pins;
	}

	/**@method setSecondScore(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午12:26:41
	*/
	public void setSecondScore(int pins) {
		this.secondScore = pins;
	}

}
