package kata.cucumber;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @ClassName: 
 * @Description:
 */
public class CukeTableStepdefs {
    private int countOfCukes;

    @Given("^I prepare some (\\d+) cukes$")
    public void i_prepare_some_cukes(int arg1) throws Throwable {
        this.countOfCukes = arg1;
        System.out.println("i_prepare_some_cukes:" + countOfCukes);
    }

    @When("^I generate a report$")
    public void i_generate_a_report(Map<String, String> map) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        for (String key : map.keySet()) {
            System.out.println(key+":" +map.get(key));
        }
    }

    @Then("^I should see the following cukes:$")
    public void the_following_users_exist(DataTable expectedCukesTable) {
        // We'd typically pull this out of a database or a web page...
        List<List<String>> rawList = expectedCukesTable.raw();
        for (List<String> fieldlist : rawList) {
            System.out.println(fieldlist);
        }
        Assert.assertEquals(this.countOfCukes, rawList.size());
    }
}
