package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepImpl extends Utils {
    ResponseSpecification respSpec;
    RequestSpecification reqSpec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add place Payload")
    public void addPlacePayload() {


        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        reqSpec = given()
                .spec(requestSpecification())
                .body(data.addPlacePayload());
    }


    @When("user calls {string} with post http request")
    public void userCallsAddPlaceAPIWithPostHttpRequest(String string) {
        response = reqSpec.when().post("/maps/api/place/add/json")
                .then().spec(respSpec).extract().response();
    }

    @Then("user receives status code {int}")
    public void userReceivesStatusCode(int arg0) {
        assertEquals(response.getStatusCode(), 200);
    }

    @And("{string} in response body is {string}")
    public void inResponseBodyIs(String keyValue, String expectedValue) {
        String resp = response.asString();
        JsonPath js = new JsonPath(resp);
        assertEquals(js.get(keyValue).toString(), expectedValue);
    }
}
