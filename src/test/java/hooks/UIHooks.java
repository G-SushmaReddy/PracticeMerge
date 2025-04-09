package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.io.ByteArrayInputStream;

public class UIHooks {

    WebDriver driver;

    public UIHooks()
    {

    }

    @Before
    public void setUp(){
        driver = DriverManager.getDriver("chrome");
    }

    @After
    public void tearDown(Scenario scenario){
        /*if(scenario.isFailed() && driver!=null)
        {
            byte[] screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
            Allure.addAttachment("Screenshot on failure",new ByteArrayInputStream(screenShot));
        }*/

        if(driver!=null)
        {
            DriverManager.quitDriver();
            System.out.println("Driver Closed");
        }
    }

    /*public WebDriver getDriver()
    {
        return this.driver;
    }*/
}
