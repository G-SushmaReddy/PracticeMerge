package tests.uiTests;

import listeners.FailedTestsListener;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import tests.baseTests.LoginBaseTest;
import java.time.Duration;

@Listeners(FailedTestsListener.class)
public class LoginTest extends LoginBaseTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);

    @Test(dataProvider = "loginData",threadPoolSize = 2)
    public void testLoginData(String username,String password) throws InterruptedException {
        login.enterTheCredentials(username, password);
        login.clickSignInButton();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.or(
                ExpectedConditions.titleIs("Welcome, Java Hipster!"),
                ExpectedConditions.presenceOfElementLocated(By.xpath("//strong"))
        ));
        String actual_url = driver.getCurrentUrl();
        String expected_url = "http://localhost:9000/";
        Assert.assertEquals(actual_url,expected_url);
    /*}
        *//*else{
            Assert.assertEquals(driver.findElement(By.xpath("//strong")).getText(),"Failed to sign in!");
        }*//*
*/

    }

}
