package tests;


import pages.HomePage;
import utils.DriverMgr;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class StepDefinitions {

    private WebDriver driver = DriverMgr.getDriver();
    private HomePage homePage = new HomePage();

    @When("I search for {string}")
    public void iSearchFor(String searchTerm) {
        homePage.search(searchTerm);
    }

    @Then("the first result should contain {string}")
    public void theFirstResultShouldContain(String expectedText) {
        String actualText = homePage.getFirstResultText();
        Assert.assertTrue(actualText.contains(expectedText), "Expected text not found in the first result.");
    }
}
