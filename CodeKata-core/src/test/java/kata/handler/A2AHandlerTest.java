package kata.handler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.testassist.BaseTest;

/**
 * @ClassName: A2AHandlerTest
 * @Description:
 */
public class A2AHandlerTest extends BaseTest {

	/**
	 * Test method for
	 * {@link kata.handler.A2AHandler#analyzeJobStep1(java.lang.String)}.
	 */
	@Test
	public final void testAnalyzeJobStep1() {
		A2AHandler handler = new A2AHandler();
		String jobName = "haha";
		assertEquals(0, handler.analyzeJobStep1(jobName));

	}

	@Test(expected = Exception.class)
	public final void testExpectedException() throws Exception {
		A2AHandler handler = new A2AHandler();
		handler.notifyBHandler();
	}

	@Test(expected = Exception.class)
	public final void testExpectedExceptionbymethodmaybethrowExceptoin() throws Exception {
		A2AHandler handler = new A2AHandler();
		handler.methodmaybethrowExceptoin("string");
	}

	@Test
	public final void testanalyzeJob2() {
		A2AHandler handler = new A2AHandler();
		String jobName = "hahddda";
		assertEquals(7, handler.analyzeJob2(jobName));

	}

	@Test
	public final void testanalyzeJobStep2inA2A() {
		A2AHandler handler = new A2AHandler();
		String jobName = "haha";
		assertEquals(4, handler.analyzeJobStep2inA2A(jobName));

	}

}
