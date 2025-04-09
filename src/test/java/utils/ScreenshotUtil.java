package utils;

import config.Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    
    public static void captureScreenshot(WebDriver driver, String testName) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
            String testTime = LocalDateTime.now().format(formatter);

            String fileName = testName + "_" + testTime + ".png";

            TakesScreenshot ts = (TakesScreenshot) driver;
            File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

            File destinationFile = new File(Constants.screenshots_path +fileName);
            FileUtils.copyFile(screenshotFile, destinationFile);

        } catch (Exception e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }
    }
}
