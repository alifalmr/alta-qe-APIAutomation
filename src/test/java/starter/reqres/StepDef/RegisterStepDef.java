package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class RegisterStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post register user with valid email and password")
    public void postRegisterUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterUser.json");
        reqresAPI.registerUser(json);
    }

    @When("Send request post register user")
    public void sendRequestPostRegisterUser() {
        SerenityRest.when().post(ReqresAPI.REGISTER_USER);
    }

    @And("Response body id should be {int}")
    public void responseBodyIsShouldBe(int id) {
        SerenityRest.then().body(ReqresResponses.ID,equalTo(id));
    }

    @And("Validate json schema register user")
    public void validateJsonSchemaRegisterUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/RegisterUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post register user with username and password")
    public void postRegisterUserWithUsernameAndPassword() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterWithUsername.json");
        reqresAPI.registerUser(json);
    }

    @Given("Post register user without password")
    public void postRegisterUserWithoutPassword() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterWithoutPassword.json");
        reqresAPI.registerUser(json);
    }

    @And("Response body error should be {string}")
    public void responseBodyErrorShouldBe(String errorMessage) {
        SerenityRest.then().body(ReqresResponses.ERROR,equalTo(errorMessage));
    }

    @Given("Post register user without email or username")
    public void postRegisterUserWithoutEmailOrUsername() {
        File json = new File(Constant.JSON_REQUEST + "/RegisterWithoutEmail.json");
        reqresAPI.registerUser(json);
    }
}
