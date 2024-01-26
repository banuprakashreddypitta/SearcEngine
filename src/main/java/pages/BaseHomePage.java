package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class BaseHomePage extends BasePage {

    public BaseHomePage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.google.com");
    }

    public String getFirstResultText() {
        WebElement firstResult = driver.findElement(By.cssSelector("ul.results li:first-child"));
        return firstResult.getText();
    }
}
