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
import util.ApiResources;
import util.TestDataBuild;
import util.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class ApiStepImpl extends Utils {
    ResponseSpecification respSpec;
    RequestSpecification reqSpec;
    Response response;
    TestDataBuild data = new TestDataBuild();

    @Given("Add place Payload with {string} {string} {string}")
    public void addPlacePayload(String name, String language, String address) {

        respSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .expectContentType(ContentType.JSON)
                .build();

        reqSpec = given()
                .spec(requestSpecification())
                .body(data.addPlacePayload(name, language, address));
    }


    @When("user calls {string} with {string} http request")
    public void userCallsAddPlaceAPIWithPostHttpRequest(String resource, String httpMethod) {
        ApiResources resourceApi = ApiResources.valueOf(resource);
        resourceApi.getResource();

        if (httpMethod.equalsIgnoreCase("POST")) {
            response = reqSpec.when().post(resourceApi.getResource());
        } else if (httpMethod.equalsIgnoreCase("GET")) {
            response = reqSpec.when().get(resourceApi.getResource());
        } else if (httpMethod.equalsIgnoreCase("PUT")) {
            response = reqSpec.when().get(resourceApi.getResource());
        } else if (httpMethod.equalsIgnoreCase("DELETE")) {
            response = reqSpec.when().get(resourceApi.getResource());
        }
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
