package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ABCommand implements Command {
	private String message;
	Logger logger = LogManager.getLogger(); 
	public ABCommand(int i) {
		message = "It is" + String.valueOf(i);
	}

	public ABCommand() {
		message = "It is Mike";
	}

	public boolean execute() {		
		logger.info(message);
		return true;
	}

}
