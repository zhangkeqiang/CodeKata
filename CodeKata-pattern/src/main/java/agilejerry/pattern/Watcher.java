package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Watcher {
	protected Logger logger = LogManager.getLogger();
	protected String Name="Anonymous";
	public void update(String str){
		logger.debug("update string is " + str);
	}
	public void setName(String thename){
		Name = thename; 
	}
}

