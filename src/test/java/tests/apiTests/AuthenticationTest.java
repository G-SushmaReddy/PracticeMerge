package tests.apiTests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.Test;
import payloads.Authenticate;
import utils.ConfigReader;
import utils.RequestBuilder;
import utils.ResponseBuilder;

import static io.restassured.RestAssured.given;

public class AuthenticationTest {

    @Test
    public static String getToken(){
        Authenticate authenticate = new Authenticate.AuthenticateBuilder()
                .setUsername("admin")
                .setPassword("admin")
                .setRememberMe(true)
                .build();

        Response response =  given()
                .spec(RequestBuilder.postRequestForAuthenticate(ConfigReader.getProperty("login.endpoint"),new JSONObject(authenticate).toString()))
                .when()
                .post()
                .then()
                .spec(ResponseBuilder.extractStringPath(200))
                .extract()
                .response();

        return response.jsonPath().getString("id_token");


    }
}
