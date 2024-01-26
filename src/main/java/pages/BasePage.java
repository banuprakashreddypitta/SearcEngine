// BasePage.java
package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    // Abstract methods to be implemented by subclasses
    public abstract void open();
    public abstract void search(String searchTerm);
    public abstract String getFirstResultText();
}
