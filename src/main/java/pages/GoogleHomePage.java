package pages;

import org.openqa.selenium.By;
import utils.DriverMgr;

public class GoogleHomePage extends BasePage {

    private static final By SEARCH_INPUT = By.name("q");
    private static final By FIRST_RESULT = By.cssSelector("h3");

    public GoogleHomePage() {
        super(DriverMgr.getDriver());
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
