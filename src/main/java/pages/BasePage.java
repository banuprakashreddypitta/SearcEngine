package pages;



import org.openqa.selenium.WebDriver;
import utils.DriverMgr;


public class BasePage {

    protected WebDriver driver;

    public BasePage() {
        this.driver = DriverMgr.getDriver();
    }
}

