package utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseBuilder {

    public static ResponseSpecification extractStringPath(int statusCode)
    {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .build();
    }
}
