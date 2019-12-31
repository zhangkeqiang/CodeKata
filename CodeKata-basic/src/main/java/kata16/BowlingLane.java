package kata16;

public class BowlingLane {
	private String message;
	public BowlingBlock roll(int pin) {
		BowlingBlock block = new BowlingBlock(pin);
		getCurrentBowler().getCurrentGame().getCurrentFrame().addBlock(block);
		message = "got" + pin;
		return block;
		
	}
	
	private Bowler getCurrentBowler() {
		return null;
		
	}

	public String showMessage() {
		return null;		
	}
}
