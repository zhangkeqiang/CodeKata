package kata16;

import java.util.ArrayList;

public class BowlingGame {
	private final int NUM_OF_FRAME = 10;
	ArrayList<BowlingFrame> alFrame = new ArrayList<BowlingFrame>();
	private int currentNoOfFrame = 0;
	public BowlingGame() {
		for(int i = 0;i<NUM_OF_FRAME;i++) {
			alFrame.add(new BowlingFrame());
		}
	}
	public BowlingFrame getCurrentFrame() {
		return alFrame.get(currentNoOfFrame );
	}
	
	
}
