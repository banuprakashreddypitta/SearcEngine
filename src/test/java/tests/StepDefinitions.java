package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import interfaces.SearchEnginePage;
import pages.GoogleHomePage;
import pages.YahooHomePage;
import pages.BingHomePage;
import utils.DriverMgr;

public class StepDefinitions {

    private SearchEnginePage currentHomePage;

    @Given("I am on the {string} search engine homepage")
    public void i_am_on_the_search_engine_homepage(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                currentHomePage = new GoogleHomePage(DriverMgr.getDriver());
                break;
            case "yahoo":
                currentHomePage = new YahooHomePage(DriverMgr.getDriver());
                break;
            case "bing":
                currentHomePage = new BingHomePage(DriverMgr.getDriver());
                break;
            default:
                throw new IllegalArgumentException("Invalid search engine: " + searchEngine);
        }

        currentHomePage.setDriver(DriverMgr.getDriver());
        currentHomePage.open();
    }

    @When("I search for {string}")
    public void i_search_for(String searchTerm) {
        currentHomePage.search(searchTerm);
    }

    @Then("the first result should contain {string}")
    public void the_first_result_should_contain(String expectedText) {
        String actualText = currentHomePage.getFirstResultText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found in the first result.");
    }
}
