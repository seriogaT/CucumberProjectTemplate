package util;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

public class Utils {
    RequestSpecBuilder specBuilder = new RequestSpecBuilder();
    public static RequestSpecification reqSpecBuild;

    @SneakyThrows
    public RequestSpecification requestSpecification() {

        if (reqSpecBuild == null) {

            PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
            reqSpecBuild = specBuilder.setBaseUri(getGlobalValue("baseUrl"))
                    .addQueryParam("key", "qaclick123")
                    .addFilter(RequestLoggingFilter.logRequestTo(log))
                    .addFilter(ResponseLoggingFilter.logResponseTo(log))
                    .setContentType(ContentType.JSON)
                    .build();

            return reqSpecBuild;
        }
        return reqSpecBuild;
    }

    @SneakyThrows
    public static String getGlobalValue(String key) {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/global.properties");
        prop.load(fis);
        return prop.getProperty(key);

    }
}
