package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
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
//        String chromedriverPath = "/Users/banuprakashreddy/IdeaProjects/SearcEngine/src/Driver/chromedriver";

        //            String srcDirectory = new File("src").getCanonicalPath();

//            String chromeDriverRelativePath = "ChromeDriver/chromedriver";
//
//            chromeDriverPath = srcDirectory + File.separator + chromeDriverRelativePath;

//        WebDriverManager.chromedriver().setup();
//
//        // Create a new instance of the Chrome driver
//        WebDriver driver = new ChromeDriver();
        chromedriverPath = "/Users/banuprakashreddy/IdeaProjects/SearcEngine/src/Driver/chromedriver-1";
//
//        //chromedriverPath = "src/ChromeDriver/chromedriver";
//
//        System.out.println("Canonical Path to ChromeDriver: " + chromedriverPath);
//        // Set up your WebDriver instance here
//        ChromeOptions options = new ChromeOptions();

//        options.setExperimentalOption("debuggerAddress", "localhost:9222");

//        options.addArguments("--remote-debugging-port=9222");
//        options.addArguments("--user-data-dir=/Users/banuprakashreddy/Documents/ChromeDi");
//
//        options.addArguments("--enable-logging", "--v=1");

//        System.setProperty("webdriver.chrome.driver", "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome");

        System.setProperty("webdriver.chrome.driver", chromedriverPath);

//        System.setProperty("webdriver.chrome.logfile", "/Users/banuprakashreddy/Documents/ChromeDi");

//        FirefoxOptions options = new FirefoxOptions();
//        options.setHeadless(true);
//        WebDriver driver = new FirefoxDriver(options);
//        System.setProperty("webdriver.gecko.driver", "/Users/banuprakashreddy/IdeaProjects/SearcEngine/src/Driver/geckodriver");

//        WebDriverManager.firefoxdriver().setup();
//         driver = new FirefoxDriver();
//        driver = new ChromeDriver(options);
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage(DriverMgr.getDriver());
        googleHomePage.setDriver(driver);
        googleHomePage.open();
        googleHomePage.search("Selenium");
        String result = googleHomePage.getFirstResultText();
        System.out.println("Google Result: " + result);
        // Add assertions as needed
    }

    @Test
    public void testYahooSearch() {
        YahooHomePage yahooHomePage = new YahooHomePage(DriverMgr.getDriver());
        yahooHomePage.setDriver(driver);
        yahooHomePage.open();
        yahooHomePage.search("WebDriver");
        String result = yahooHomePage.getFirstResultText();
        System.out.println("Yahoo Result: " + result);
        // Add assertions as needed
    }

    @Test
    public void testBingSearch() {
        BingHomePage bingHomePage = new BingHomePage(DriverMgr.getDriver());
        bingHomePage.setDriver(driver);
        bingHomePage.open();
        bingHomePage.search("Automation Testing");
        String result = bingHomePage.getFirstResultText();
        System.out.println("Bing Result: " + result);
        // Add assertions as needed
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser or perform cleanup here
        if (driver != null) {
            driver.quit();
        }
    }
}
