package tests;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.BaseHomePage;
import pages.GoogleHomePage;
import pages.YahooHomePage;
import pages.BingHomePage;

public class StepDefinitions {

    private BaseHomePage currentHomePage;
    @Given("I am on the {string} search engine homepage")
    public void iAmOnTheSearchEngineHomepage(String searchEngine) {
        switch (searchEngine.toLowerCase()) {
            case "google":
                currentHomePage = new GoogleHomePage();
                break;
            case "yahoo":
                currentHomePage = new YahooHomePage();
                break;
            case "bing":
                currentHomePage = new BingHomePage();
                break;
            default:
                throw new IllegalArgumentException("Invalid search engine: " + searchEngine);
        }

        currentHomePage.open();
    }

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        currentHomePage.search(searchTerm);
    }

    @Then("the first result should contain {string}")
    public void theFirstResultShouldContain(String expectedText) {
        String actualText = currentHomePage.getFirstResultText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found in the first result.");
    }
}
