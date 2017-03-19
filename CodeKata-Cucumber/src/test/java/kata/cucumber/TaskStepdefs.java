package kata.cucumber;

import java.util.List;

import org.junit.Assert;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * @ClassName: TaskStepdefs
 * @Description:
 */
public class TaskStepdefs {
    int taskOnBacklog;

    TaskManager manager = new TaskManager();
    @Given("^my task list has (\\d+) tasks$")
    public void my_task_list_has_total_tasks(int total) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("my_task_list_has_total_tasks:" + total);
        manager.setTotal(total);
    }

    @When("^I finished (\\d+) tasks$")
    public void i_finished_finished_tasks(int finished) throws Throwable {
        manager.setDone(finished);
       
    }

    @Then("^I have (\\d+) tasks left$")
    public void i_have_left_tasks_left(int left) throws Throwable {
        Assert.assertEquals(left, manager.getLeft());
    }
}
