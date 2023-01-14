package starter.reqres.StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import io.restassured.module.jsv.JsonSchemaValidator;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;
import starter.reqres.ReqresAPI;
import starter.reqres.Utils.Constant;

import java.io.File;

public class ListResourcesStepDef {
    @Steps
    ReqresAPI reqresAPI;

    @Given("Get list resources")
    public void getListResources() {
        reqresAPI.setListResources();
    }

    @When("Send request get list resources")
    public void sendRequestGetListResources() {
        SerenityRest.when().get(ReqresAPI.LIST_RESOURCES);
    }

    @And("Validate json schema list resources")
    public void validateJsonSchemaListResources() {
        File jsonSchema = new File(Constant.JSON_SCHEMA + "/ListResourcesSchema.json");
        SerenityRest.then().body(JsonSchemaValidator.matchesJsonSchema(jsonSchema));
    }

    @Given("Get list resources with page {int}")
    public void getListResourcesWithPage(int page) {
        reqresAPI.setPageListResources(page);
    }

    @When("Send request get list resources with page")
    public void sendRequestGetListResourcesWithPage() {
        SerenityRest.when().get(ReqresAPI.PAGE_LIST_RESOURCES);
    }

    @Given("Get list resources with per_page {int}")
    public void getListResourcesWithPer_page(int perPage) {
        reqresAPI.setPerpageListResources(perPage);
    }

    @When("Send request get list resources with per_page")
    public void sendRequestGetListResourcesWithPer_page() {
        SerenityRest.when().get(ReqresAPI.PERPAGE_LIST_RESOURCES);
    }

    @Given("Get list resources with per_page {int} and page {int}")
    public void getListResourcesWithPer_pageAndPage(int perPage, int page) {
        reqresAPI.setPagePerpageListResources(perPage,page);
    }

    @When("Send request get list resources with per_page and page")
    public void sendRequestGetListResourcesWithPer_pageAndPage() {
        SerenityRest.when().get(ReqresAPI.PAGE_PERPAGE_LIST_RESOURCES);
    }
}
