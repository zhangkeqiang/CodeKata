package kata.handler;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class A1HandlerTest {
    @Test
    public void testA1_protected_method_should_be_called(){
        A1Handler a1 = new A1Handler();
        Assert.assertEquals(1004, a1.analyzeJobStep1("ddd"));
        assertThat(23, is(24));
    }
}
