package org.example.page.apiEngine;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.example.page.components.BaseComponent;
import org.example.utils.ReadConfigFile;

public class EndPoints extends BaseComponent {

    public EndPoints() {
    }


    static ReadConfigFile config = new ReadConfigFile();
    static String apiBaseURL = config.getProperty("apiURL");


    public static String getBearerToken() {
        bearerToken = config.getProperty("bearerToken");
        return bearerToken;
    }

    public static Response updateProperty(String properyId, String propertyValue) {
        RequestSpecification request  = RestAssured.given().log().all();
        request.header("Authorization", "Bearer " + getBearerToken())
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Host", "evra-backend-api.prod.wdtech.org");

        String body = "{"
                + "\"id\": \"" + properyId + "\","
                + "\"favourite\": " + propertyValue
                + "}";

        response = request
                .body(body)
                .patch(apiBaseURL + "/properties/" + properyId);

        System.out.println("Response: " + response.asString());
        return response;
    }


}
