package interfaces;

import org.openqa.selenium.WebDriver;

public interface SearchEnginePage {
    void setDriver(WebDriver driver);
    void open();
    void search(String searchTerm);
    String getFirstResultText();
}