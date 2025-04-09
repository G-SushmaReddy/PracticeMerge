package com.epam.restaurent.hooks;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.restassured.response.Response;

import java.io.ByteArrayInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiHooks {

    private static Response lastResponse;
    @Before
    public void setup() {
        System.out.println("Setting up test environment...");
    }

    @After
    public void teardown(Scenario scenario) {
        if (lastResponse != null) {
            Allure.addAttachment("Response Body", new ByteArrayInputStream(lastResponse.getBody().asString().getBytes()));
        }

        if (scenario.isFailed()) {
            System.out.println("Test failed: " + scenario.getName());
        }
    }
    public static void setLastResponse(Response response) {
        lastResponse = response;
    }
}

