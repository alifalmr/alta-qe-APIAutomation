package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class LoginStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Post login user with valid email and password")
    public void postLoginUserWithValidJson() {
        File json = new File(Constant.JSON_REQUEST + "/Login.json");
        reqresAPI.setLOGIN(json);
    }

    @When("Send request post login user")
    public void sendRequestPostLoginUser() {
        SerenityRest.when().post(ReqresAPI.LOGIN);
    }

    @And("Validate json schema login user")
    public void validateJsonSchemaLoginUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/LoginSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Post login user without password")
    public void postLoginUserWithInvalidJson() {
        File json = new File(Constant.JSON_REQUEST + "/InvalidLogin.json");
        reqresAPI.setLOGIN(json);
    }

    @Given("Post login user with valid username and password")
    public void postLoginUserWithValidUsernameAndPassword() {
        File json = new File(Constant.JSON_REQUEST + "/LoginWithUsername.json");
        reqresAPI.setLOGIN(json);
    }

    @Given("Post login user without email")
    public void postLoginUserWithoutEmail() {
        File json = new File(Constant.JSON_REQUEST + "/LoginWithoutEmail.json");
        reqresAPI.setLOGIN(json);
    }
}
