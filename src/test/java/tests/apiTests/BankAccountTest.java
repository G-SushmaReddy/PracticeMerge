package tests.apiTests;

import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import payloads.BankAccount;
import utils.ConfigReader;
import utils.RequestBuilder;
import utils.ResponseBuilder;

import static io.restassured.RestAssured.given;

public class BankAccountTest {
    private static String token;
    private static int id;

    @BeforeClass
    public void setUp(){
        token = AuthenticationTest.getToken();
    }

    @Test
    public void testPostBankAccount(){
        BankAccount bankAccount = new BankAccount.BankAccountBuilder()
                .setName("Sushma")
                .setBalance(1234.56)
                .build();

        JSONObject jsonObject = new JSONObject(bankAccount);
        jsonObject.remove("id");

        Response response = given()
                .spec(RequestBuilder.postRequestForBank(ConfigReader.getProperty("bank.accounts.endpoint"),token,jsonObject.toString()))
                .when()
                .post()
                .then()
                .spec(ResponseBuilder.extractStringPath(201))
                .extract()
                .response();

        id = response.jsonPath().getInt("id");
    }

    @Test(dependsOnMethods = "testPostBankAccount")
    public void testDeleteBankAccount(){

        given()
                .spec(RequestBuilder.deleteRequestForBank(ConfigReader.getProperty("delete.bank.account.endpoint"),token))
                .pathParam("id",id)
                .when()
                .delete("{id}")
                .then()
                .spec(ResponseBuilder.extractStringPath(204));
    }
}
