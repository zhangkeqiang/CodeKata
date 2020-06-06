package agilejerry.pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AACommand implements Command {
	
	Logger logger = LogManager.getLogger();  //LogManager.ROOT_LOGGER_NAME
	private int iI;
	public AACommand(int i){
		this.iI = i;
	}
	
	public AACommand(){
		this.iI = 10;
	}
	public boolean execute() {
		logger.info("AACommand"  + iI);
		return true;
	}

}
