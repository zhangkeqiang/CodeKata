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
	public boolean isOver() {
		return (state.equals("STRIKE") || state.equals("SECONDBLOCK")) ;
	}

}
