package com.epam.restaurent.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features.authentication/AuthenticationFeature.feature", // Path to feature files
        glue = "com.epam.restaurent.stepDefinitions.api", // Path to step definitions
        plugin = {"pretty" ,  "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}, // Simple readable output
        monochrome = true // Improves readability of console output
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
