package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class Utils {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    RequestSpecification reqSpecBuild;

    public RequestSpecification requestSpecification() {

        reqSpecBuild = specBuilder.setBaseUri("https://rahulshettyacademy.com")
                .addQueryParam("key", "qaclick123")
                .setContentType(ContentType.JSON)
                .build();

        return reqSpecBuild;
    }
}
