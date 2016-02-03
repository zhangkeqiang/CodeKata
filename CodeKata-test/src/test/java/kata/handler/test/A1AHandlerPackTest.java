package kata.handler.test;


import org.junit.Assert;
import org.junit.Test;

import kata.handler.A1AHandler;

public class A1AHandlerPackTest extends A1AHandler {
    @Test
    public void testanalyzeJobStep1(){
        Assert.assertEquals(1003, analyzeJobStep1("jobName"));
    }
}
