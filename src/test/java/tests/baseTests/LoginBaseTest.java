package tests.baseTests;

import config.Constants;
import listeners.FailedTestsListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverManager;
import utils.ExcelUtil;


public class LoginBaseTest {
    protected WebDriver driver;
    protected LoginPage login;

    @BeforeMethod
    public void openLoginPage() {
        driver = DriverManager.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get(ConfigReader.getProperty("login.base.url"));
        login = new LoginPage(driver);
    }

    @DataProvider(name = "loginData")
    public Object[][] loadLoginData(){
        return ExcelUtil.getLoginData(Constants.excel_sheet_path, Constants.login_excel_sheet_name);
    }

    @AfterMethod
    public void tearDown(){
        DriverManager.quitDriver();
    }
}
