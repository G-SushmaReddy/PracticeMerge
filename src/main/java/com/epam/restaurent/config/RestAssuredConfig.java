package com.epam.restaurent.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;


public class RestAssuredConfig {
    public static RequestSpecification getRequestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(ConfigurationReader.getInstance().getProperty("BASE_URI"))
                .setContentType("application/json")
                .build();
    }
}
