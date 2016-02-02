package kata.handler;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class A1HandlerTestFromSubClass extends A1Handler{
    @Test
    public void testA1_protected_method_should_be_called(){        
        Assert.assertEquals(1004, analyzeJobStep1("ddd"));
    }
}
