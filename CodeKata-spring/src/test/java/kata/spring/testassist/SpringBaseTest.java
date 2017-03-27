package kata.spring.testassist;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kata.testassist.BaseTest;

/**@ClassName: SpringBaseTest
 * @Description:  
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:applicationTestContext.xml") 
public class SpringBaseTest extends BaseTest{



}
