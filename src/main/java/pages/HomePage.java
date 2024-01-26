package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BaseHomePage {

    // Constructor for HomePage
    public HomePage(WebDriver driver) {
        super(driver);  // Call the constructor of the superclass (BaseHomePage)
    }

    public void search(String searchTerm) {
        // Assuming you have a search input field with the name 'q'
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(searchTerm);
        searchInput.submit();
    }

    public String getFirstResultText() {
        // Assuming you have a search result element with the class 'rc'
        WebElement firstResult = driver.findElement(By.className("rc"));
        return firstResult.getText();
    }

}
