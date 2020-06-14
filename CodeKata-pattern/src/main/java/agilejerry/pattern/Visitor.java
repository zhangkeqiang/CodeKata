package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Visitor {
	protected Logger logger = LogManager.getLogger();
	public boolean visit(Visited visited) {
		logger.debug("Start to Visit " + visited.toString());
		return true;
	}

	public boolean visit(VisitedFriend visited) {
		logger.debug("Start to Visit Friend " + visited.toString());
		return true;
	}
	
	public void shakeHand(VisitedFriend visitedFriend) {
		logger.debug("ShakeHand with " + visitedFriend.toString());
	}
	
	

}
