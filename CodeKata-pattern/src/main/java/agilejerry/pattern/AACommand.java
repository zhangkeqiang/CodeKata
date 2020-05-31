package agilejerry.pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AACommand implements Command {
	
	Logger logger = LogManager.getLogger();  //LogManager.ROOT_LOGGER_NAME
	private int II;
	public AACommand(int i){
		this.II = i;
	}
	
	public AACommand(){
		this.II = 10;
	}
	public boolean execute() {
		logger.info("AACommand"  + II);
		return true;
	}

}
