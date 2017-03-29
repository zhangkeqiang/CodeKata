package kata.spring.testassist;

import static org.junit.Assert.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kata.testassist.BaseTest;

/**@ClassName: SpringBaseTest
 * @Description:  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationTestContext.xml") 
public abstract class SpringBaseTest extends AbstractJUnit4SpringContextTests {
    protected static final Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Rule
    public TestName name = new TestName();

    @Before
    public void init() {
        logger.info("===Start " + name.getMethodName());
    }
/*    @Test
    public void test(){
        logger.info(this.applicationContext.getDisplayName());
    }*/
    @After
    public void tearDown() throws Exception {
        logger.info("===End " + name.getMethodName());
    }

}
