package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class screenshotOnFailure {

    // Passing WebDriver driver as a parameter
    public screenshotOnFailure(WebDriver driver, ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            System.out.println("Test failed!");
            System.out.println("Taking Screenshot....");
            captureScreenshotOnFailure(driver, result.getName());
        }
    }

    // Static method to capture screenshot on failure
    public static void captureScreenshotOnFailure(WebDriver driver, String screenshotName) {
        Path destination = Paths.get("./Screenshots", screenshotName + ".png");
        try {
            Files.createDirectories(destination.getParent());
            FileOutputStream out = new FileOutputStream(destination.toString());
            out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
            out.close();
        } catch (IOException e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }
    }
}
