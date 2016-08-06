package kata.bowling;

/**
 * @ClassName: Game
 * @Description: BowlingGame, 10 frames
 */
public class Game {

	Frame[] frames = new Frame[10];
	private int currentFrameNo = 1;

	/**
	 * @method roll(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月23日 下午5:55:30
	 */
	public void roll(int pins) {
		if (currentFrameNo > 10)
			return;
		if (currentFrameNo == 10) {
			if (frames[currentFrameNo - 1] == null) {
				frames[currentFrameNo - 1] = new Frame(currentFrameNo);
				frames[currentFrameNo - 1].setFirstScore(pins);
				calculateGameScore();
			} else if (frames[9].getSecondScore() == BowlingTerm.BLANK) {
				frames[currentFrameNo - 1].setSecondScore(pins);
				calculateGameScore();
			} else {
				frames[currentFrameNo - 1].setThirdScore(pins);
				calculateGameScore();
				currentFrameNo++;
			}

		} else if (frames[currentFrameNo - 1] == null) {
			frames[currentFrameNo - 1] = new Frame(currentFrameNo);
			frames[currentFrameNo - 1].setFirstScore(pins);
			calculateGameScore();
			if (pins == BowlingTerm.STRIKE)
				currentFrameNo++;
		} else {
			frames[currentFrameNo - 1].setSecondScore(pins);
			calculateGameScore();
			currentFrameNo++;
		}

	}

	/**
	 * @method calculateGameScore(这里用一句话描述这个方法的作用)
	 * @return void
	 * @author Administrator
	 * @date 2016年7月24日 上午12:57:00
	 */
	private void calculateGameScore() {
		for (int i = 0; i < currentFrameNo; i++) {
			if (frames[i].checkScoreIsCalculated())
				continue;
			int frameScore = BowlingTerm.BLANK;
			if (i < 8) {
				// 1-8Frame 计分如下
				if (frames[i].getTotalScore() == BowlingTerm.X_STRIKE) {
					// strike
					if (currentFrameNo > i + 1) {
						if (frames[i + 1].getFirstScore() == BowlingTerm.STRIKE) {
							if (currentFrameNo > i + 2)
								frameScore = BowlingTerm.STRIKE * 2 + frames[i + 2].getFirstScore();
						} else if (frames[i + 1].getSecondScore() > BowlingTerm.BLANK)
							frameScore = BowlingTerm.STRIKE + frames[i + 1].getFirstScore()
									+ frames[i + 1].getSecondScore();
					}
				} else if (frames[i].getTotalScore() == BowlingTerm.SLASH_SQARE) {
					if (currentFrameNo > i + 1)
						frameScore = BowlingTerm.STRIKE + frames[i + 1].getFirstScore();
				} else if (frames[i].getSecondScore() > BowlingTerm.BLANK) {
					frameScore = frames[i].getFirstScore() + frames[i].getSecondScore();
				}
			} else if (i == 8) {
				if (frames[i].getTotalScore() == BowlingTerm.X_STRIKE && currentFrameNo == 10) {
					if (frames[i + 1].getSecondScore() > BowlingTerm.BLANK) {
						frameScore = BowlingTerm.STRIKE + frames[i + 1].getFirstScore()
								+ frames[i + 1].getSecondScore();
					}
				} else if (frames[i].getTotalScore() == BowlingTerm.SLASH_SQARE && currentFrameNo == 10) {
					if (frames[i + 1].getFirstScore() > BowlingTerm.BLANK)
						frameScore = BowlingTerm.STRIKE + frames[i + 1].getFirstScore();
				} else if (frames[i].getSecondScore() > BowlingTerm.BLANK
						&& frames[i].getTotalScore() != BowlingTerm.SLASH_SQARE) {
					frameScore = frames[i].getFirstScore() + frames[i].getSecondScore();
				}
			} else if (i == 9) {
				if (frames[i].getFirstScore() == BowlingTerm.STRIKE) {
					if (frames[i].getThirdScore() > BowlingTerm.BLANK) {
						frameScore = BowlingTerm.STRIKE + frames[i].getSecondScore() + frames[i].getThirdScore();
					}
				} else if (frames[i].getTotalScore() == BowlingTerm.SLASH_SQARE) {
					if (frames[i].getThirdScore() > BowlingTerm.BLANK) {
						frameScore = BowlingTerm.STRIKE + frames[i].getThirdScore();
					}
				} else {
					if (frames[i].getSecondScore() > BowlingTerm.BLANK)
						frameScore = frames[i].getFirstScore() + frames[i].getSecondScore();
				}
			}
			if (frameScore != BowlingTerm.BLANK)
				frames[i].setTotalScore(frameScore);
		}
	}

	/**
	 * @method isGameOver(这里用一句话描述这个方法的作用)
	 * @return boolean
	 * @author Administrator
	 * @date 2016年7月24日 上午12:53:36
	 */
	private boolean isGameOver() {
		if (currentFrameNo < 10)
			return false;
		if (frames[9] == null)
			return false;
		if (frames[9].getSecondScore() == BowlingTerm.BLANK)
			return false;
		if (frames[8].getTotalScore() == BowlingTerm.X_STRIKE)
			return false;
		if (frames[9].getTotalScore() == BowlingTerm.X_STRIKE || frames[9].getTotalScore() == BowlingTerm.SLASH_SQARE)
			return false;
		return true;
	}

	/**
	 * @method calculate the current score of the game
	 * @return score
	 * @author Mike
	 * @date 2016年7月23日 下午5:56:28
	 */
	public int getScore() {
		if (frames[9] == null)
			return BowlingTerm.BLANK;
		int score = 0;
		for (int i = 0; i < 10; i++) {
			score += frames[i].getTotalScore();
		}
		return score;
	}

	/**
	 * @method getFrame(这里用一句话描述这个方法的作用)
	 * @return Frame
	 * @author Administrator
	 * @date 2016年7月24日 上午12:11:46
	 */
	public Frame getFrame(int no) {
		return frames[no - 1];
	}

}
