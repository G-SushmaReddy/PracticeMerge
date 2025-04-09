package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private static final ThreadLocal<WebDriver> threadLocal = new ThreadLocal<>();

    private DriverManager(){

    }

    public static WebDriver getDriver(String browser){
        if(threadLocal.get() == null)
        {
            threadLocal.set(DriverFactory.createDriver(browser));
        }
        return threadLocal.get();
    }

    public static void quitDriver(){
        if(threadLocal.get()!=null)
        {
            threadLocal.get().quit();
            threadLocal.remove();
        }
    }

}
