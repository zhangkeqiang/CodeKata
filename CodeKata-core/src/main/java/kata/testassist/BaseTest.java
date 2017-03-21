package kata.testassist;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;

public abstract class BaseTest {
    protected static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Rule
    public TestName name = new TestName();

    @Before
    public void init() {
        logger.info("===Start " + name.getMethodName());
    }

    @After
    public void tearDown() throws Exception {
        logger.info("===End " + name.getMethodName());
    }
}
