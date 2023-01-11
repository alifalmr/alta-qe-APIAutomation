package starter.reqres;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static org.hamcrest.Matchers.equalTo;

public class ListUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list user with page {int}")
    public void getListUserWithPage(int page) {
        reqresAPI.setGetListUser(page);
    }

    @When("Send request get list users")
    public void sendRequestGetListUser() {
        SerenityRest.when().get(ReqresAPI.GET_LIST_USER);
    }

    @Then("Should return status code {int}")
    public void shouldReturnStatusCode(int ok) {
        SerenityRest.then().statusCode(ok);
    }

    @And("Response body should page should be {int}")
    public void responseBodyShouldPageShouldBe(int page) {
        SerenityRest.then().body("page",equalTo(page));
    }

    @Given("Get list user with page {string}")
    public void getListUserWithPage(String param) {
        reqresAPI.setGetListUser(param);
    }
}
