package kata16;

import java.util.ArrayList;

public class Bowler {
	ArrayList<BowlingGame> alGame = new ArrayList<BowlingGame>();
	private int currentGameNum = 0;

	public Bowler(int numOfMatch) {
		for (int i = 0; i < numOfMatch; i++) {
			alGame.add(new BowlingGame());
		}

	}

	public BowlingGame getCurrentGame() {
		return alGame.get(currentGameNum);
	}

	public BlockResult addBlock(BowlingBlock block) {
		return this.getCurrentGame().addBlock(block);
	}

	public String getMessage() {
		String message = "Current Game:No."+(currentGameNum+1);
		message += getCurrentGame().getMessage();
		return message;
	}

}
