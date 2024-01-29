package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BingHomePage;
import pages.GoogleHomePage;
import pages.YahooHomePage;
import utils.DriverMgr;

import java.io.File;
import java.io.IOException;

public class SearchTests {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {

        String chromedriverPath = null;

        chromedriverPath = "/Users/banuprakashreddy/IdeaProjects/SearcEngine/src/Driver/chromedriver-1";


        System.setProperty("webdriver.chrome.driver", chromedriverPath);

        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(DriverMgr.getDriver());
        googleHomePage.setDriver(driver);
        googleHomePage.open();
        googleHomePage.search("Selenium");
        String result = googleHomePage.getFirstResultText();
        Assert.assertTrue(result.contains("Selenium"), "Expected result to contain 'Selenium'");
    }

    @Test
    public void testYahooSearch() {
        YahooHomePage yahooHomePage = new YahooHomePage(DriverMgr.getDriver());
        yahooHomePage.setDriver(driver);
        yahooHomePage.open();
        yahooHomePage.search("WebDriver");
        String result = yahooHomePage.getFirstResultText();
        System.out.println("Yahoo Result: " + result);
        Assert.assertTrue(result.contains("WebDriver"), "Expected result to contain 'WebDriver'");
    }

    @Test
    public void testBingSearch() {
        BingHomePage bingHomePage = new BingHomePage(DriverMgr.getDriver());
        bingHomePage.setDriver(driver);
        bingHomePage.open();
        bingHomePage.search("Automation Testing");
        String result = bingHomePage.getFirstResultText();
        System.out.println("Bing Result: " + result);
        Assert.assertTrue(result.contains("Automation Testing"), "Expected result to contain 'Automation Testing'");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
