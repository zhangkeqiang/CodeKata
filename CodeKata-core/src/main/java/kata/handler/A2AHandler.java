package kata.handler;

/**
 * @ClassName: A2AHandler
 * @Description: to show how to handle the exception
 */
public class A2AHandler extends AHandler {

	@Override
	protected int analyzeJobStep1(String jobName) {
		logger.info(jobName + " is running");
		int nRet = 0;
		try {
			notifyBHandler();
			nRet = analyzeJobStep2inA2A(jobName);
		} catch (Exception e) {
			logger.error("notifyBHandler trigger exception", e);
		}
		return nRet;
	}

	protected void notifyBHandler() throws Exception {
		logger.error("send message out,it is time-comsuming.");
		throw new Exception("remote service is not reachable");

	}

	/**
	 * @method methodmaybethrowExceptoin
	 * @description just to throw a Exception
	 * @return void
	 */
	public void methodmaybethrowExceptoin(String name) throws Exception {
		throw new Exception("Just Exception");
	}

	protected int analyzeJob2(String name) {
		return analyzeJobStep2inA2A(name);
	}

	protected int analyzeJobStep2inA2A(String param) {
		return param.length();
	}
}
