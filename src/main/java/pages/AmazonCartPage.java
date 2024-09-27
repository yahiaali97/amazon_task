package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonCartPage {
    WebDriver driver;
    WebDriverWait wait;


    public AmazonCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locating Add to Cart Btn and Cart Item
    By addToCartButton = By.id("add-to-cart-button");
    By cartItem = By.cssSelector(".sc-list-item-content");

    // Method to add item to cart
    public void addItemToCart() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        driver.findElement(addToCartButton).click();
    }

    // Method to check if the item is in cart
    public boolean isItemAdded() {
        return driver.findElement(cartItem).isDisplayed();
    }

    // Method to navigate to cart
    public void goToCart() {
        driver.navigate().to("https://www.amazon.com/gp/cart/view.html");
    }
}
