package kata.cucumber;
import org.junit.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import kata.cucumber.Belly;

/**@ClassName: Stepdefs
 * @Description:  
 */
public class RunCukesStepdefs {
    Belly belly = new Belly();
    @Given("^I have (\\d+) cukes in my belly$")
    public void I_have_cukes_in_my_belly(int cukes) throws Throwable {

        belly.eat(cukes);
    }
    
    @When("^I wait (\\d+) hour$")
    public void i_wait_hour(int m) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        belly.wait(m);
    }

    @Then("^my belly should growl to (\\d+)$")
    public void my_belly_should_growl(int g) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        //throw new PendingException();
        int ret = belly.getGrowl();
        Assert.assertEquals(g, ret);
    }
}
