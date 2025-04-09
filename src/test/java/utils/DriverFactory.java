package utils;

import customExceptions.NoBrowserFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

    public static WebDriver createDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "chrome"->new ChromeDriver();
            case "edge"-> new EdgeDriver();
            case "firefox"-> new FirefoxDriver();
            default-> throw new NoBrowserFoundException();
        };
    }
}
