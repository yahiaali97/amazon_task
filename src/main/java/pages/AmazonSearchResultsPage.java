package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class AmazonSearchResultsPage {
    WebDriver driver;
    public Actions action;

    // Constructor
    public AmazonSearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locator for the first item
    By firstItem = By.xpath("//span[contains(text(),'LISEN Retractable Car Charger')]");

    // Method to select the first item
    public void selectFirstItem() {
        // Scroll down slightly to locate the first item
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);"); // Scroll down 200 pixels

        driver.findElement(firstItem).click();
    }
}