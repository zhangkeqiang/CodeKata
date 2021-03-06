package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class EITE implements EITI {
	protected EITContext context = EITContext.getInstance();
	protected Logger logger = LogManager.getLogger();

	public int run() {
		logger.debug("EITE.run...run1 = " + run1());
		return run1() + run2();
	}

	protected abstract int run1();

	protected abstract int run2();

	public void setContextI(int i) {
		context.setI(i);
	}
}
