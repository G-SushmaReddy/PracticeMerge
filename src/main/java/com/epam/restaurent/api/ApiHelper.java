package com.epam.restaurent.api;

import com.epam.restaurent.common.ExamplePojo;
import com.epam.restaurent.config.ConfigurationReader;
import com.epam.restaurent.config.RestAssuredConfig;
import com.epam.restaurent.common.AuthenticationPojo;
import com.google.gson.Gson;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiHelper {
    private static final String ENDPOINT = ConfigurationReader.getInstance().getProperty("AUTH_ENDPOINT");

    public static Response registerUser(ExamplePojo user) {
        return given()
                .spec(RestAssuredConfig.getRequestSpec())
                .body(new Gson().toJson(user))
                .when()
                .post(ENDPOINT);
    }

}
