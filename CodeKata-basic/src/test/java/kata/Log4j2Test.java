package kata;

import static org.junit.Assert.assertNotNull;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Log4j2Test {
    @Rule
    public TestName name = new TestName();
    protected Logger log = LogManager.getLogger(Log4j2Test.class);
    static int i = 0;
    static int j = 0;

    @Before
    public void init() {
        log.info("Start " + name.getMethodName());
        log.info("init time:" + (++i));
    }

    @After
    public void tearDown() throws Exception {
        log.info("after time:" + i);
        log.info("End " + name.getMethodName());
    }

    @BeforeClass
    public static void beforeClass() {
        LogManager.getLogger(Log4j2Test.class).info("beforeclass time:" + (++j));
        
    }

    @AfterClass
    public static void afterClass() {
        LogManager.getLogger(Log4j2Test.class).info("afterclass time:" + (j));
    }

    @Test
    public void testLog4j2() {
        log.info(name.getMethodName());
        assertNotNull(log);
        log.trace("trace message");
        log.debug("debug message");
        log.info("info message");
        log.warn("warn message");
        log.error("error message");
        log.fatal("fatal message");
    }

    @Test
    public void testLog4j2debug() {
        log.debug("debug message");
        log.debug("debug message2");
    }

    @Test
    public void testLog4j2fatal() {
        log.fatal("fatal message");
    }

}
