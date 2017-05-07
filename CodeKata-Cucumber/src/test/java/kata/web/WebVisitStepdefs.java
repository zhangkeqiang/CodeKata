package kata.web;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.DataTable;
import cucumber.api.Format;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @ClassName: TaskStepdefs
 * @Description:
 */
public class WebVisitStepdefs {   
    WebDriver driver;
    @Given("^I visit \"([^\"]*)\"$")
    public void i_visit_http_localhost(String url) throws Throwable {
        System.out.println(url);
        String geckodriverpath = "C:\\IDE\\geckodriver-v0.16.1-win64\\geckodriver.exe";
        //System.setProperty("webdriver.firefox.marionette", geckodriverpath);
        System.setProperty("webdriver.gecko.driver",geckodriverpath);
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);
        driver = new FirefoxDriver(capabilities);
        driver.get(url);
        
    }

    @When("^I click on \"([^\"]*)\"$")
    public void i_click_on(String linkstring) throws Throwable {
        System.out.println(linkstring);
        driver.findElement(By.linkText(linkstring)).click();
    }

    @Then("^I see \"([^\"]*)\"$")
    public void i_see(String message) throws Throwable {
        System.out.println(message);
        assertEquals(message, driver.getTitle());
        driver.close();
    }
}
