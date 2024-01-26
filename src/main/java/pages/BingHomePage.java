package pages;

import org.openqa.selenium.By;
import utils.DriverMgr;

public class BingHomePage extends BasePage {

    private static final By SEARCH_INPUT = By.name("q");
    private static final By FIRST_RESULT = By.cssSelector(".b_algo header h2");

    public BingHomePage() {
        super(DriverMgr.getDriver());
    }

    @Override
    public void open() {
        driver.get("https://www.bing.com/");
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
