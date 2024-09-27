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
import pages.AmazonTodaysDealsPage;
import utilities.screenshotOnFailure;

public class AmazonTodaysDealsTest {
    private static WebDriver driver;
    private AmazonHomePage homePage;
    private AmazonTodaysDealsPage dealsPage;
    private AmazonCartPage cartPage;

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(1024, 768));

        // Initialize page objects
        homePage = new AmazonHomePage(driver);
        dealsPage = new AmazonTodaysDealsPage(driver);
        cartPage = new AmazonCartPage(driver);
    }

    @Test
    public void testAddItemFromTodaysDealsToCart() {
        try {
            // Step 1: Open Amazon and go to Today's Deals
            driver.navigate().to("https://www.amazon.com/");
            homePage.openTodaysDeals();

            // Step 2: Select "Grocery" from filters
            dealsPage.selectFilters();

            // Step 3: Choose the discount of "10% off or more"
            dealsPage.selectDiscountFilter();

            // Step 4: Select any item and add it to the cart
            dealsPage.selectAnyItem();

            // Add item to cart
            dealsPage.addItemToCart();

            // Verify the item is added
            cartPage.goToCart();
            Assert.assertTrue(cartPage.isItemAdded(), "Item was not added to cart from Today's Deals.");
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