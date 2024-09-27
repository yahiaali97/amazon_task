package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AmazonHomePage {
    WebDriver driver;
    WebDriverWait wait;

    // Constructor to initialize WebDriver
    public AmazonHomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for search box
    By searchBox = By.id("twotabsearchtextbox");
    By TodayDeals = By.linkText("Today's Deals");

    // Method to perform search
    public void searchItem(String item) {
        // Waiting for the search box to be clickable
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(searchBox).sendKeys(item);
        driver.findElement(searchBox).submit();
    }

    // Method to navigate to today's deals
    public void openTodaysDeals() {
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(searchBox));
        driver.findElement(TodayDeals).click();
    }
}