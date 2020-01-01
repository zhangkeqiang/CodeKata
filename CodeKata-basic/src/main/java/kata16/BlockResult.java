package kata16;

public class BlockResult {
	private String message;
	private String state;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public BlockResult(String message, String state) {
		this.message = message;
		this.state = state;
	}

	public BlockResult(BowlingBlock block, String state) {
		this.state = state;
		if (block.getPin() == 0) {
			this.message = "Gutter Ball!";
		}else if(state.equals("SPARE")) {
			this.message = "Spare!";
		}
		else if (state.equals("STRIKE")) {
			this.message = "Strike!";
		} else {
			this.message = "Next Block";
		}
	}

	public boolean isOver() {
		return (state.equals("STRIKE") || state.equals("SECONDBLOCK") || state.equals("SPARE"));
	}

}
