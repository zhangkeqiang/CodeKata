package kata.fitnesse;

import org.junit.Assert;
import org.junit.Test;



public class HelloFitnesseTest {
    @Test
    public void test_HelloFitnesse_say() {
        HelloFitnesse hello = new HelloFitnesse();
        Assert.assertEquals("Hello", hello.sayHello());
    }

}
