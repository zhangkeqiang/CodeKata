package kata.handler;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import kata.testassist.BaseTest;
public class A1HandlerTest extends BaseTest{
    @Test
    public void testA1_protected_method_should_be_called(){
        A1Handler a1 = new A1Handler();
        assertEquals(1004, a1.analyzeJobStep1("ddd"));
        logger.warn("dfdsfssddsdfsfdss");
    }
}
