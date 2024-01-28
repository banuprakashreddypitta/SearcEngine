package pages;

import interfaces.SearchEnginePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YahooHomePage extends BasePage implements SearchEnginePage {

    private static final By SEARCH_INPUT = By.name("p");
    private static final By FIRST_RESULT = By.cssSelector(".ac-algo");

    public YahooHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void open() {
        driver.get("https://www.yahoo.com/");
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

    @Override
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }
}
