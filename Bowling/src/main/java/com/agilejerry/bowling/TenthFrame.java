package com.agilejerry.bowling;

import kata.bowling.BowlingTerm;

public class TenthFrame extends BowlingFrame {

	private boolean _isOver = false;

	public TenthFrame(int i) {
		super(i);
	}

	@Override
	public boolean isOver() {
		return _isOver;
	}

	@Override
	protected int calculateScore() {
		switch (state) {
		case BowlingTerm.FRAME_RUNNING:
			return BowlingTerm.BLANK;
		case BowlingTerm.FRAME_NORMALOVER:
			score = this.previousFrame.getScore() + rolls[0].getPins() + rolls[1].getPins();
			break;
		case BowlingTerm.SLASH_SQARE:
			if (this.rolls[2] != null) {
				score = this.previousFrame.getScore() + 10 + rolls[2].getPins();
			}
			break;
		case BowlingTerm.X_STRIKE:
			score = this.previousFrame.getScore() + 10 + getRoll(1).getPins() + getRoll(2).getPins();
			break;
		default:
			//nothing is needed
			break;
		}
		return score;
	}

	@Override
	protected void showFrameState(int pins) {
		if (currentRollNo == 1) {
			if (pins < BowlingTerm.STRIKE) {
				this.state = BowlingTerm.FRAME_RUNNING;
				prepare(10 - rolls[0].getPins());
			} else if (pins == BowlingTerm.STRIKE) {
				this.state = BowlingTerm.X_STRIKE;
				prepare(10);
			}
		} else if (currentRollNo == 2) {
			if (this.state == BowlingTerm.X_STRIKE) {
				if (pins == BowlingTerm.STRIKE)
					prepare(10);
				else
					prepare(10 - pins);
			} else if ((pins + rolls[0].getPins()) < BowlingTerm.STRIKE) {
				this.state = BowlingTerm.FRAME_NORMALOVER;
				this._isOver = true;
			} else if ((pins + rolls[0].getPins()) == BowlingTerm.STRIKE) {
				this.state = BowlingTerm.SLASH_SQARE;
				prepare(10);
			}
		} else {
			_isOver = true;
		}
	}

}
