package kata.bowling2;

import java.util.LinkedList;

import kata.bowling.BowlingTerm;

/**
 * @ClassName: BowlingGame
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @date 2016年7月24日 上午7:36:42
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class BowlingGame {

	LinkedList<BowlingFrame> frameList = new LinkedList<BowlingFrame>();
	int currentFrameNo = 0;

	/**
	 * @method newFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年7月24日 上午7:37:12
	 */
	public BowlingFrame newFrame() {
		return new BowlingFrame(currentFrameNo, this);
	}

	/**
	 * @method roll(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午9:13:57
	 */
	public void roll(int pins) {		
		if (getCurrentFrame() ==null || getCurrentFrame().isOver()) {
			currentFrameNo++;
			BowlingFrame newFrame = newFrame();
			newFrame.roll(pins);
			frameList.add(newFrame);
		}else if(currentFrameNo < BowlingTerm.STRIKE){
			getCurrentFrame().roll(pins);
		}else if(currentFrameNo == BowlingTerm.STRIKE){
			getCurrentFrame().roll_2_3BallInTenth(pins);
		}
	}

	/**
	 * @method getCurrentFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年7月24日 上午9:15:38
	 */
	public BowlingFrame getCurrentFrame() {
		if(frameList.isEmpty())
			return null;
		if(frameList.size() >= currentFrameNo )
			return frameList.get(currentFrameNo - 1);
		return null;
	}

	/**@method getFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年7月24日 上午10:37:48
	*/
	public BowlingFrame getFrame(int i) {
		if(frameList.isEmpty())
			return null;
		if(frameList.size() >= i )
			return frameList.get(i-1);
		return null;
	}

	/**@method getNextFrame(这里用一句话描述这个方法的作用)
	 * @return BowlingFrame
	 * @author Administrator
	 * @date 2016年7月24日 上午10:55:25
	*/
	public BowlingFrame getNextFrame(int _No) {
		return getFrame(_No+1);
	}

	/**@method getTotalScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 下午2:32:01
	*/
	public int getTotalScore() {
		int totalScore = 0;
		for(int i=0;i<10;i++){
			totalScore += frameList.get(i).getTotalScore();
		}
		return totalScore;
	}

}
