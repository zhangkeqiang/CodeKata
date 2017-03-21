package kata.cucumber.table;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @ClassName: 
 * @Description:
 */
public class CukeTableStepdefs {
    private int countOfCukes;

    @Given("^I prepare (\\d+) cukes$")
    public void i_prepare_cukes(int arg1) throws Throwable {
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
    public void i_should_see_following_cukes(DataTable expectedCukesTable) {
        // We'd typically pull this out of a database or a web page...
        List<List<String>> rawList = expectedCukesTable.raw();
        System.out.println("Show the cukes======");
        for (List<String> fieldlist : rawList) {
            System.out.println(fieldlist);
        }
        Assert.assertEquals(this.countOfCukes, rawList.size());
    }
    
    @Given("^I like cuke$")
    public void i_like_cuke(DataTable table) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        System.out.println(table.getGherkinRows().get(0).getCells().get(0));
        System.out.println(table.topCells().get(1));
        System.out.println("i_need_belle");
    }
    
    @Then("^I should not see ([^\"]*) cakes$")
    public void i_should_not_see_cakes(String arg1) throws Throwable {
        float cakeQuantity = Float.parseFloat(arg1);
        Assert.assertEquals("float compare", cakeQuantity, 5.14, 0.0001);
    }
}
