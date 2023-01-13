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

public class SingleUserStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get a user with id {int}")
    public void getAUserWithId(int id) {
        reqresAPI.setSingleUser(id);
    }

    @When("Send request get a user")
    public void sendRequestGetAUser() {
        SerenityRest.when().get(ReqresAPI.SINGLE_USER);
    }

    @And("Response body data.id should be {int}")
    public void responseBodyDataIdShouldBeId(int dataID) {
        SerenityRest.then().body(ReqresResponses.DATA_ID,equalTo(dataID));
    }

    @And("Validate json schema single user")
    public void validateJsonSchemaSingleUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/SingleUserSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }
}
