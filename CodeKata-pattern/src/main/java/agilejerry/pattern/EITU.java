package agilejerry.pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class EITU {
	protected Logger logger = LogManager.getLogger();
	EITI eit;
	EITCommander commander;

	public void setEIT() {
		this.eit = EITCommander.createEITI();
	}

	public void run() {
		if (eit != null) {
			eit.run();
		} else {
			logger.debug("EIT is null");
		}
	}

	public void setCommander(EITCommander theCommander) {
		commander = theCommander;
	}

	public int calc() {
		int iRet = 0;

		return iRet;
	}

}
