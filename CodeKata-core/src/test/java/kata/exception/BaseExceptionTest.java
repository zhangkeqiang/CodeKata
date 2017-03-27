package kata.exception;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kata.testassist.BaseTest;

public class BaseExceptionTest extends BaseTest {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test(expected = BaseException.class)
    public final void test() throws BaseException {
        String typeOfException = "BaseException";
        String message = "hello, Exception";
        BaseException exception = ExceptionHandler.createException(typeOfException, message);
        logger.error("BaseException", exception);
        throw exception;
    }

    @Test
    public final void testfinally(){
        int i = 0;
        try{
            test();
            i++;
            fail();
        }catch(BaseException e){
            logger.error("test exceptoin", e);
            assertEquals(0,i++);
        }finally{
            assertEquals(1,i++);
        }
        assertEquals(2,i);
    }

}
