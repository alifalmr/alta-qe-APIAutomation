package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Fields;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;
import starter.reqres.Utils.ReqresResponses;

import java.io.File;

import static org.hamcrest.Matchers.equalTo;

public class ListUsersStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list users with page {int}")
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
        SerenityRest.then().body(ReqresResponses.PAGE,equalTo(page));
    }

    @Given("Get list users with page {string}")
    public void getListUserWithPage(String param) {
        reqresAPI.setGetListUser(param);
    }

    @And("Validate json schema list users")
    public void validateJsonSchemaListUser() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListUsersSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list users with parameter per_page {int}")
    public void getListUsersWithParameterPer_page(int perPage) {
        reqresAPI.setPerpageListUsers(perPage);
    }

    @When("Send request get list users with parameter per_page")
    public void sendRequestGetListUsersWithParameterPer_page() {
        SerenityRest.when().get(ReqresAPI.PERPAGE_LIST_USERS);
    }

    @And("Response body per_page should be {int} and total_pages should be {int}")
    public void responseBodyPer_pageShouldBeAndTotal_pagesShouldBe(int perPage, int totalPages) {
        SerenityRest.then()
                    .body(ReqresResponses.PER_PAGE,equalTo(perPage))
                    .body(ReqresResponses.TOTAL_PAGES,equalTo(totalPages));
    }

    @And("Validate json schema list users per_page")
    public void validateJsonSchemaListUsersPer_page() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListPerPageSchema.json");
        SerenityRest.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list users with parameter per_page {int} and page {int}")
    public void getListUsersWithParameterPer_pageAndPage(int perPage, int page) {
        reqresAPI.setPagePerpageListUsers(perPage,page);
    }

    @When("Send request get list users with parameter per_page and page")
    public void sendRequestGetListUsersWithParameterPer_pageAndPage() {
        SerenityRest.when().get(ReqresAPI.PAGE_PERPAGE_LIST_USERS);
    }

    @And("Response body page should be {int}, per_page should be {int} and total_pages should be {int}")
    public void responseBodyPageShouldBeAndPer_pageShouldBe(int page, int perPage, int totalPages) {
        SerenityRest.then()
                    .body(ReqresResponses.PAGE,equalTo(page))
                    .body(ReqresResponses.PER_PAGE,equalTo(perPage))
                    .body(ReqresResponses.TOTAL_PAGES,equalTo(totalPages));
    }
}
