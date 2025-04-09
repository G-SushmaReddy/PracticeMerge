package com.epam.restaurent.stepDefinitions.api;


import com.epam.restaurent.api.ApiHelper;
import com.epam.restaurent.common.AuthenticationPojo;
import com.epam.restaurent.common.ExamplePojo;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import static org.junit.Assert.assertEquals;
import io.qameta.allure.Step;

public class AuthenticationSteps {
    private Response response;
    private ExamplePojo user;

    @Given("I have valid user details")
    public void i_have_valid_user_details(){
        user = new ExamplePojo.Builder()
                .setUserId(23)
                .setBody("India")
                .setTitle("Pakistan")
                .build();
    }
//    private AuthenticationPojo user;
//
//    @Given("I have valid user details")
//    public void i_have_valid_user_details() {
//        user = new AuthenticationPojo.AuthenticationBuilder()
//                .setFirstName("John")
//                .setLastName("Smith")
//                .setEmail("john_smith@example.com")
//                .setPassword("Y2kjqKHX")
//                .build();
//    }

    @When("I send a registration request")
    public void i_send_a_registration_request() {
        response = ApiHelper.registerUser(user);
    }

    @Then("I should get a response with status code {int}")
    public void i_should_get_a_response_with_status_code(int statusCode) {
        assertEquals(statusCode, response.getStatusCode());
    }
}
