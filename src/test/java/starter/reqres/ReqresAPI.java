package starter.reqres;

import io.cucumber.java.eo.Se;
import io.restassured.http.ContentType;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import starter.reqres.Utils.Constant;

import java.io.File;

public class ReqresAPI {
//    public static String BASE_URL = "https://reqres.in";
    public static String GET_LIST_USER = Constant.BASE_URL + "/api/users?page={page}";
    public static String PERPAGE_LIST_USERS = Constant.BASE_URL + "/api/users?per_page={per_page}";
    public static String PAGE_PERPAGE_LIST_USERS = PERPAGE_LIST_USERS + "&page={page}";
    public static String POST_CREATE_USER = Constant.BASE_URL + "/api/users";
//    public static final String DIR = System.getProperty("user.dir");
//    public static String JSON_REQUEST = Constant.DIR+"/src/test/resources/JSON/Request";
    public static String PUT_UPDATE_USER = Constant.BASE_URL + "/api/users/{id}";
    public static String DELETE_USER = Constant.BASE_URL + "/api/users/{id}";
//    public static String JSON_SCHEMA = Constant.DIR + "/src/test/resources/JSON/JsonSchema";
    public static String REGISTER_USER = Constant.BASE_URL + "/api/register";
    public static String SINGLE_USER = Constant.BASE_URL + "/api/users?id={id}";
    public static String LIST_RESOURCES = Constant.BASE_URL + "/api/unknown";
    public static String PAGE_LIST_RESOURCES = LIST_RESOURCES + "?page={page}";
    public static String PERPAGE_LIST_RESOURCES = LIST_RESOURCES + "?per_page={per_page}";
    public static String PAGE_PERPAGE_LIST_RESOURCES = PERPAGE_LIST_USERS + "&page={page}";
    public static String LOGIN = Constant.BASE_URL + "/api/login";

    @Step("Get list users")
    public void setGetListUser(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list users with string parameter")
    public void setGetListUser(String page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list users with parameter per_page")
    public void setPerpageListUsers(int perPage){
        SerenityRest.given().pathParam("per_page",perPage);
    }

    @Step("Get list users with parameter per_page and page")
    public void setPagePerpageListUsers(int perPage, int page){
        SerenityRest.given()
                    .pathParam("per_page",perPage)
                    .pathParam("page",page);
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

    @Step("Post register user")
    public void registerUser(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

    @Step("Get single user")
    public void setSingleUser(int id){
        SerenityRest.given().pathParam("id",id);
    }

    @Step("Get list resources")
    public void setListResources(){
        SerenityRest.given();
    }

    @Step("Get list resouces with parameter page")
    public void setPageListResources(int page){
        SerenityRest.given().pathParam("page",page);
    }

    @Step("Get list resouces with parameter per_page")
    public void setPerpageListResources(int perPage){
        SerenityRest.given().pathParam("per_page",perPage);
    }

    @Step("Get list resouces with parameter per_page and page")
    public void setPagePerpageListResources(int perPage, int page){
        SerenityRest.given()
                    .pathParam("per_page",perPage)
                    .pathParam("page",page);
    }

    @Step("Post login user")
    public void setLOGIN(File json){
        SerenityRest.given()
                    .contentType(ContentType.JSON)
                    .body(json);
    }

}
