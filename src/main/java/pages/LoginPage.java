package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    private By username = By.id("username");
    private By password = By.id("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By enterLoginIn = By.xpath("//a[.='sign in']");

    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void enterToLoginPage()
    {
        driver.findElement(enterLoginIn).click();
    }

    public void enterTheCredentials(String usernameText, String passwordText) {
        driver.findElement(username).sendKeys(usernameText);
        driver.findElement(password).sendKeys(passwordText);
        //Thread.sleep(3000);
    }

    public void clickSignInButton()
    {
        driver.findElement(loginButton).click();
    }

    public String navigatedHomePageUrl(){
        return driver.getCurrentUrl();
    }

}
