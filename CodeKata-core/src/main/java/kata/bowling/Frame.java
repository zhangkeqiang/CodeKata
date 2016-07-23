package kata.bowling;

/**@ClassName: Frame
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月23日 下午6:04:07 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class Frame {


	private static final int SLASH_SQARE = -3;
	/**
	 * show X for strike, not has next 2 deliver
	 */
	private static final int X_STRIKE = -2;
	/**
	 * Strike get score 10
	 */
	private static final int STRIKE = 10;

	/**
	 * no score ,show blank
	 */
	private static final int BLANK = -1;
	private int frameNo;
	private int firstScore = BLANK;
	private int secondScore = BLANK;

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
		if(firstScore == STRIKE){
			return X_STRIKE;
		}
		if(firstScore < 0 || secondScore < 0){
			return BLANK;
		}
		return (firstScore + secondScore) == 10 ? SLASH_SQARE: (firstScore + secondScore);
		
	}

	/**@method deliver(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月23日 下午11:04:46
	*/
	public void deliver(int sequence, int pins) {
		if(sequence == 1){
			this.firstScore = pins;
		}else if(sequence == 2){
			this.secondScore = pins;
		}
	}

}
