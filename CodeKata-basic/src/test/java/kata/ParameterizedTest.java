package kata;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.apache.logging.log4j.LogManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTest {
    private int fInput;
    private int fExpected;
    public ParameterizedTest(int input, int expected)
    {
        fInput = input;
        fExpected = expected;
    }
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("beforeclass time");
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("before");
    }

    @After
    public void tearDown() throws Exception {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("after");
    }

    @Parameters
    public static Collection<Object[]> data()
    {
        return Arrays.asList(new Object[][] { { 0, 0 }, { 1, 1 }, { 233, 233 },
                { 3, 3 }, { 4, 4 }, { 5, 5 }, { 8, 8 } });
    }

    @Test
    public void test1() {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("test1");
        assertEquals(fExpected, fInput);

    }
    @Test
    public void test2() {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("test2");
        assertEquals(fExpected, fInput);

    }
    
    @Test
    public void test3() {
        LogManager.getLogger(LogManager.ROOT_LOGGER_NAME).info("test3");
        assertEquals(fExpected, fInput);

    }
}
