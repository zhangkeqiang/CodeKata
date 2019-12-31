package kata16;

import java.util.ArrayList;

public class Bowler {
	ArrayList<BowlingGame> alGame = new ArrayList<BowlingGame>();
	private int NoOfGame = 0;

	public Bowler(int numOfMatch) {
		for (int i = 0; i < numOfMatch; i++) {
			alGame.add(new BowlingGame());
		}

	}

	public BowlingGame getCurrentGame() {
		return alGame.get(NoOfGame);
	}

	public BlockResult addBlock(BowlingBlock block) {
		return this.getCurrentGame().getCurrentFrame().addBlock(block);
	}

}
