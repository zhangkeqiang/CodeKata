package agilejerry.pattern;

public class ABCommand implements Command {
	private String message;
	public ABCommand(int i) {
		message = "It is" + String.valueOf(i);
	}

	public ABCommand() {
		message = "It is Mike";
	}

	public boolean execute() {
		System.out.println(message);
		return true;
	}

}
