package pages;

import interfaces.SearchEnginePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage implements SearchEnginePage {

    private WebDriver driver;
    private static final By SEARCH_INPUT = By.name("q");
    private static final By FIRST_RESULT = By.cssSelector("h3");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @Override
    public void open() {
        driver.get("https://www.google.com/");
    }

    @Override
    public void search(String searchTerm) {
        driver.findElement(SEARCH_INPUT).sendKeys(searchTerm);
        driver.findElement(SEARCH_INPUT).submit();
    }

    @Override
    public String getFirstResultText() {
        return driver.findElement(FIRST_RESULT).getText();
    }
}
