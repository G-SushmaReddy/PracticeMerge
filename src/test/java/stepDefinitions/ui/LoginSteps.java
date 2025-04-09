package stepDefinitions.ui;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LoginPage;
import utils.DriverManager;

public class LoginSteps{
    protected WebDriver driver;
    protected LoginPage loginPage;

    public LoginSteps()
    {
        this.driver = DriverManager.getDriver("chrome");
        loginPage = new LoginPage(driver);
    }

    @Given("the user is on the home page")
    public void setUp(){
        driver.get("http://localhost:9000/");

    }

    @When("the user enters into the login page")
    public void entersTheLoginPage()
    {
        loginPage.enterToLoginPage();
    }

    @And("the user enters the username {string} and password {string}")
    public void entersTheDetails(String username,String password)
    {
        loginPage.enterTheCredentials(username,password);
    }

    @And("the user clicks on the sign in button")
    public void clicksTheSignInButton() throws InterruptedException {
        loginPage.clickSignInButton();
        Thread.sleep(2000);
    }

    @Then("the user is redirected to the homepage")
    public void checkIfEntersHomePage(){
        String expectedUrl = loginPage.navigatedHomePageUrl();
        String actualUrl = "http://localhost:9000/";
        Assert.assertEquals(actualUrl,expectedUrl);
    }

    @Then("the error message is displayed")
    public void FailsIfEnterInvalidCredentials(){
        String expectedErrorMessage=driver.findElement(By.xpath("//strong")).getText();
        String actualErrorMessage = "Failed to sign in!";
        Assert.assertEquals(actualErrorMessage,expectedErrorMessage);
    }

}