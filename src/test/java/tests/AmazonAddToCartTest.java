package tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.AmazonCartPage;
import pages.AmazonHomePage;
import pages.AmazonSearchResultsPage;
import utilities.screenshotOnFailure;

public class AmazonAddToCartTest {
    private static WebDriver driver;
    private AmazonHomePage homePage;
    private AmazonSearchResultsPage searchResultsPage;
    private AmazonCartPage cartPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));

        // Initialize page objects
        homePage = new AmazonHomePage(driver);
        searchResultsPage = new AmazonSearchResultsPage(driver);
        cartPage = new AmazonCartPage(driver);
    }

    @Test
    public void testAddCarAccessoriesToCart() {
        try {
            // Step 1: Open Amazon and search for car accessories
            driver.get("https://www.amazon.com/");
            homePage.searchItem("car accessories");

            // Step 2: Select the first item from search results
            searchResultsPage.selectFirstItem();

            // Step 3: Add the item to the cart
            cartPage.addItemToCart();

            // Step 4: Go to cart and verify the item is added
            cartPage.goToCart();
            Assert.assertTrue(cartPage.isItemAdded(), "Item was not added to cart.");
        } catch (Exception e) {
            // Capture screenshot on failure
            screenshotOnFailure.captureScreenshotOnFailure(driver, "AmazonTestFailure");
            System.out.println("Test failed: " + e.getMessage());
            Assert.fail("Test execution failed.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}