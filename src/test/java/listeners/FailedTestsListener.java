package listeners;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import utils.DriverManager;
import utils.ScreenshotUtil;

import java.io.File;
import java.lang.reflect.Field;
import java.time.LocalDate;
import java.time.LocalTime;

public class FailedTestsListener implements ITestListener {

    public void onTestFailure(ITestResult result)
    {
        String testName = result.getTestName();
        Object testInstance = result.getInstance();

        try {
            Field field = testInstance.getClass().getSuperclass().getDeclaredField("driver");
            field.setAccessible(true);
            WebDriver driver = (WebDriver) field.get(testInstance);
            //WebDriver driver = (WebDriver) testInstance.getClass().getDeclaredField("driver").get(testInstance);
            ScreenshotUtil.captureScreenshot(driver,testName);
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
    }
}
