package utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    private static final String BASE_URI =
            "https://dummyjson.com";

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()
                .setBaseUri(BASE_URI)
                .setContentType(ContentType.JSON)
                .build();
    }
}