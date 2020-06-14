package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VisitedLover extends Visited {

	protected Logger logger = LogManager.getLogger();
	@Override
	public boolean accept(Visitor visitor) {
		visitor.visit(this);
		kiss(visitor);
		return true;
	}

	private void kiss(Visitor visitor) {
		logger.debug("Kiss!" + visitor.toString());
	}

}
