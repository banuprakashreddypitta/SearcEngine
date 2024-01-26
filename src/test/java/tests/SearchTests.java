package tests;



import org.testng.annotations.Test;
import pages.BingHomePage;
import pages.GoogleHomePage;
import pages.YahooHomePage;

public class SearchTests {

    @Test
    public void testGoogleSearch() {
        GoogleHomePage googleHomePage = new GoogleHomePage();
        googleHomePage.open();
        googleHomePage.search("Selenium");
        String result = googleHomePage.getFirstResultText();
        System.out.println("Google Result: " + result);
        // Add assertions as needed
    }

    @Test
    public void testYahooSearch() {
        YahooHomePage yahooHomePage = new YahooHomePage();
        yahooHomePage.open();
        yahooHomePage.search("WebDriver");
        String result = yahooHomePage.getFirstResultText();
        System.out.println("Yahoo Result: " + result);
        // Add assertions as needed
    }

    @Test
    public void testBingSearch() {
        BingHomePage bingHomePage = new BingHomePage();
        bingHomePage.open();
        bingHomePage.search("Automation Testing");
        String result = bingHomePage.getFirstResultText();
        System.out.println("Bing Result: " + result);
        // Add assertions as needed
    }
}
