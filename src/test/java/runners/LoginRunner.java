package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/Features/ui/login.feature",
        glue = {"stepDefinitions/ui","hooks"},
        plugin = {"pretty" ,  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, // Simple readable output
        monochrome = true // Improves readability of console output
)

public class LoginRunner extends AbstractTestNGCucumberTests {

}
