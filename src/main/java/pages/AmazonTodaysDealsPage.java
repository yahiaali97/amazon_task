package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonTodaysDealsPage {
    public Actions action;
    WebDriver driver;
    WebDriverWait wait;
    By Grocery = By.xpath("//button[contains(@data-testid, 'filter-bubble-grocery')]");

    // Constructor
    public AmazonTodaysDealsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Method to select "Grocery" >> There is no Headphones Category
    public void selectFilters() {
        // Right Arrow for next Categories
        WebElement nextIcon = driver.findElement(By.cssSelector(".a-icon.a-icon-next"));

        // Click the element three times
        nextIcon.click();
        nextIcon.click();
        nextIcon.click();

        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(Grocery));
        driver.findElement(Grocery).click();
    }

    // Method to select discount filter
    public void selectDiscountFilter() {
        // Scroll down to the bottom of the page to locate the discount filter
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

        driver.findElement(By.cssSelector("span.a-size-base.a-color-base")).click();
    }

    // Method to select any item on the page >> There is no fourth page
    public void selectAnyItem() {
        // Wait for the product name to be present
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement Coffee = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div[data-asin='B084GY7284'] a[data-testid='product-card-link']")));

        Coffee.click();
    }

    // Method to add item to cart
    public void addItemToCart() {
        // Scroll down slightly to locate the first item
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 3000);"); // Scroll down 3000 pixels

        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(
                By.cssSelector("input[name='submit.addToCart'][data-asins='[\"B0D5F42SNQ\"]']")));
        addToCartButton.click();
    }
}