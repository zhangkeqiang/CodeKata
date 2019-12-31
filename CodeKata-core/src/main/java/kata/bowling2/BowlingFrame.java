package kata.bowling2;

import java.util.ArrayList;
import java.util.List;

import kata.bowling.BowlingTerm;

/**
 * @ClassName: BowlingFrame
 * @Description: 保留球的一个计分格
 * @author Administrator
 * @date 2016年7月24日 上午7:32:34
 */
public class BowlingFrame {
	private static final int FRAME_INIT = 0;
	List<BowlingRoll> rollList = new ArrayList<BowlingRoll>();
	int state = FRAME_INIT;
	private int _No;
	private BowlingGame game;
	private int totalScore = BowlingTerm.BLANK;

	/**
	 * (这里用一句话描述这个构造函数的作用)
	 * 
	 * @param currentFrameNo
	 * @param game
	 */
	public BowlingFrame(int currentFrameNo, BowlingGame game) {
		this._No = currentFrameNo;
		this.game = game;
	}

	/**
	 * @method roll(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午7:41:41
	 */
	public void roll(int pins) {
		if (state == FRAME_INIT) {
			BowlingRoll roll = new BowlingRoll(10);
			roll.setPins(pins);
			rollList.add(roll);
			if (pins == 10)
				state = BowlingTerm.X_STRIKE;
			else
				state = BowlingTerm.FRAME_RUNNING;
		} else if (state == BowlingTerm.FRAME_RUNNING && this._No == 10) {
			// handle
		} else if (state == BowlingTerm.FRAME_RUNNING) {
			BowlingRoll roll = new BowlingRoll(10 - rollList.get(0).getPins());
			if (pins > roll.getMaxPins())
				return;
			roll.setPins(pins);
			rollList.add(roll);
			if ((rollList.get(0).getPins() + pins) == 10) {
				state = BowlingTerm.SLASH_SQARE;
			} else {
				state = BowlingTerm.FRAME_NORMALOVER;
			}
		}
	}

	/**
	 * @method rollInTenth(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 下午2:48:24
	 */
	public void roll_2_3BallInTenth(int pins) {
		if (state == BowlingTerm.X_STRIKE) {
			BowlingRoll roll = new BowlingRoll(10);
			roll.setPins(pins);
			rollList.add(roll);
		} else if (state == BowlingTerm.FRAME_RUNNING) {
			BowlingRoll roll = new BowlingRoll(10 - rollList.get(0).getPins());
			if (pins > roll.getMaxPins())
				return;
			roll.setPins(pins);
			rollList.add(roll);
			if ((rollList.get(0).getPins() + pins) == 10) {
				state = BowlingTerm.SLASH_SQARE;
			} else {
				state = BowlingTerm.FRAME_NORMALOVER;
			}
		} else if (state == BowlingTerm.SLASH_SQARE) {
			BowlingRoll roll = new BowlingRoll(10);
			roll.setPins(pins);
			rollList.add(roll);
		}
	}

	/**
	 * @method getFirstScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午7:45:18
	 */
	public int getFirstScore() {
		return rollList.get(0).getPins();
	}

	/**
	 * @method getSecondScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午9:08:28
	 */
	public int getSecondScore() {
		if (rollList.size() < 2) {
			return BowlingTerm.BLANK;
		}
		return rollList.get(1).getPins();
	}

	/**
	 * @method isOver(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午9:33:00
	 */
	public boolean isOver() {
		if (this._No < 10)
			return (state == BowlingTerm.FRAME_NORMALOVER || state == BowlingTerm.X_STRIKE
					|| state == BowlingTerm.SLASH_SQARE);
		else
			return checkTenthOver();
	}

	/**
	 * @method checkTenthOver(这里用一句话描述这个方法的作用)
	 * @return boolean
	 * @author Administrator
	 * @date 2016年7月24日 下午2:56:39
	 */
	private boolean checkTenthOver() {
		if (state == BowlingTerm.FRAME_NORMALOVER)
			return true;
		if (getRollScore(3) != BowlingTerm.BLANK)
			return true;
		return false;
	}

	/**
	 * @method getTotalScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午9:45:50
	 */
	public int getTotalScore() {
		if (totalScore == BowlingTerm.BLANK) {
			if (this._No < 9) {
				return calculateScore();
			} else if (this._No == 9) {
				return calculateScoreAtNinthFrame();
			} else if (this._No == 10) {
				return calculateScoreAtTenthFrame();
			}
		} else {
			return totalScore;
		}
		return BowlingTerm.ABNORMAL;
	}

	/**
	 * @method calculateScoreAtTenthFrame(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月24日 下午3:18:50
	 */
	private int calculateScoreAtTenthFrame() {
		if (state == BowlingTerm.FRAME_RUNNING) {
			return BowlingTerm.BLANK;
		}
		if (state == BowlingTerm.FRAME_NORMALOVER) {
			totalScore = rollList.get(0).getPins() + rollList.get(1).getPins();
			return totalScore;
		}
		if (state == BowlingTerm.X_STRIKE) {
			if (getRollScore(3) != BowlingTerm.BLANK) {
				totalScore = BowlingTerm.STRIKE + getRollScore(2) + getRollScore(3);
				return totalScore;
			}
			return BowlingTerm.X_STRIKE;
		}
		return 0;
	}

	/**
	 * @method calculateScoreAtNinthFrame(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月24日 下午3:06:14
	 */
	private int calculateScoreAtNinthFrame() {
		if (state == BowlingTerm.FRAME_RUNNING) {
			return BowlingTerm.BLANK;
		}
		if (state == BowlingTerm.FRAME_NORMALOVER) {
			totalScore = rollList.get(0).getPins() + rollList.get(1).getPins();
			return totalScore;
		}
		if (state == BowlingTerm.X_STRIKE) {
			BowlingFrame frame10 = game.getFrame(10);
			if (frame10 != null && frame10.getSecondScore() != BowlingTerm.BLANK) {
				totalScore = BowlingTerm.STRIKE + frame10.getFirstScore() + frame10.getSecondScore();
				return totalScore;
			}
			return BowlingTerm.X_STRIKE;
		}
		return 0;
	}

	/**
	 * @method calculateScore(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月24日 上午10:33:43
	 */
	private int calculateScore() {
		if (state == BowlingTerm.FRAME_RUNNING) {
			return BowlingTerm.BLANK;
		}
		if (state == BowlingTerm.FRAME_NORMALOVER) {
			totalScore = rollList.get(0).getPins() + rollList.get(1).getPins();
			return totalScore;
		}
		if (state == BowlingTerm.X_STRIKE) {
			if (game.getCurrentFrame().getNo() > this._No) {
				BowlingFrame nextFrame = game.getNextFrame(this._No);
				if (nextFrame == null) {
					return BowlingTerm.X_STRIKE;
				}
				return calculateScoreWhenNextFrame(nextFrame);
			}
			return BowlingTerm.X_STRIKE;
		}
		if (state == BowlingTerm.SLASH_SQARE) {
			if (game.getCurrentFrame().getNo() > this._No) {
				BowlingFrame nextFrame = game.getNextFrame(this._No);
				totalScore = BowlingTerm.STRIKE + nextFrame.getFirstScore();
				return totalScore;
			}
			return BowlingTerm.SLASH_SQARE;
		}
		return BowlingTerm.ABNORMAL;
	}

	private int calculateScoreWhenNextFrame(BowlingFrame nextFrame) {
		if (nextFrame.getState() == BowlingTerm.X_STRIKE) {
			BowlingFrame nextnextFrame = game.getFrame(this._No + 2);
			if (nextnextFrame == null)
				return BowlingTerm.X_STRIKE;
			else
				totalScore = 2 * BowlingTerm.STRIKE + nextnextFrame.getFirstScore();

		} else if (nextFrame.getSecondScore() != BowlingTerm.BLANK) {
			totalScore = BowlingTerm.STRIKE + nextFrame.getFirstScore() + nextFrame.getSecondScore();
		}
		return totalScore;
	}

	/**
	 * @method getState(这里用一句话描述这个方法的作用)
	 * @return int
	 * @author Administrator
	 * @date 2016年7月24日 上午10:58:20
	 */
	int getState() {
		return this.state;
	}

	/**
	 * @method getNo(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 上午9:50:25
	 */
	public int getNo() {
		return this._No;
	}

	public void setNo(int _No) {
		this._No = _No;
	}

	/**
	 * @method getRollScore(这里用一句话描述这个方法的作用)
	 * @return Object
	 * @author Administrator
	 * @date 2016年7月24日 下午3:00:14
	 */
	public int getRollScore(int i) {
		if (rollList.size() < i) {
			return BowlingTerm.BLANK;
		}
		return rollList.get(i - 1).getPins();
	}

}
