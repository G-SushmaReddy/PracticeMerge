package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.oauth2;

public class RequestBuilder {

    public static RequestSpecification deleteRequestForBank(String uri,String token)
    {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setAuth(oauth2(token))
                .setContentType("application/json")
                .build();
    }

    public static RequestSpecification postRequestForBank(String uri,String token,String body)
    {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setAuth(oauth2(token))
                .setContentType("application/json")
                .setBody(body)
                .build();
    }

    public static RequestSpecification postRequestForAuthenticate(String uri,String body)
    {
        return new RequestSpecBuilder()
                .setBaseUri(uri)
                .setContentType("application/json")
                .setBody(body)
                .build();
    }

}
