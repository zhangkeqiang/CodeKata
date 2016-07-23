package kata.bowling;

/**@ClassName: Game
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Administrator 
 * @date 2016年7月23日 下午5:54:33 
 * @Copyright © 2016上海通善互联网金融信息服务有限公司
 */
public class Game {

	Frame[] frames = new Frame[10];
	private int currentFrameNo = 1;
	/**@method roll(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月23日 下午5:55:30
	*/
	public void roll(int pins) {
		if(frames[currentFrameNo-1] == null){
			frames[currentFrameNo-1] = new Frame(currentFrameNo);
			frames[currentFrameNo-1].setFirstScore(pins);
		}else{
			frames[currentFrameNo-1].setSecondScore(pins);
			currentFrameNo++;
		}
	}

	/**@method calculate the current score of the game
	 * @return score
	 * @author Mike
	 * @date 2016年7月23日 下午5:56:28
	*/
	public int score() {
		return BowlingTerm.BLANK;
	}

	/**@method getFrame(这里用一句话描述这个方法的作用)
	 * @return Frame
	 * @author Administrator
	 * @date 2016年7月24日 上午12:11:46
	*/
	public Frame getFrame(int no) {
		return frames[no-1];
	}

}
