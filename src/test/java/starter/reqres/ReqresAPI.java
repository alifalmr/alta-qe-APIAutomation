package starter.reqres;

import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.io.File;

public class ReqresAPI {
    public static String BASE_URL = "https://reqres.in";
    public static String GET_LIST_USER = BASE_URL + "/api/users?page={page}";
    public static String POST_CREATE_USER = BASE_URL + "/api/users";
    public static final String DIR = System.getProperty("user.dir");
    public static String JSON_REQUEST = DIR+"/src/test/resources/JSON/Request";
    public static String PUT_UPDATE_USER = BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = BASE_URL + "/api/users/{id}";

    @Step("Get list users")
    public void setGetListUser(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list users with string parameter")
    public void setGetListUser(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Post create user")
    public void postCreateUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Put update user")
    public void putUpdateUser(int id, File json){
        SerenityRest.given()
                    .pathParam("id",id)
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Delete user")
    public void deleteUser(int id){
        SerenityRest.given().pathParam("id",id);
    }
}
