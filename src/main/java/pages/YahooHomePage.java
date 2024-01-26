package pages;

import org.openqa.selenium.By;
import utils.DriverMgr;

public class YahooHomePage extends BasePage {

    private static final By SEARCH_INPUT = By.name("p");
    private static final By FIRST_RESULT = By.cssSelector(".ac-algo");

    public YahooHomePage() {
        super(DriverMgr.getDriver());
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
}
