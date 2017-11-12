package kata.cucumber.table;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**@ClassName: RunCukesTest
 * @Description:  
 */
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {
        "pretty" }, features = {
                "src/test/resources/cuketable.feature" },
                glue = {"kata.cucumber.table"}, monochrome = true)
public class CukeTableTest {

}
