package org.example;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class Testimonial {
    public static void main(String[] args) {

        //Given, When and Then
        RestAssured.baseURI = "https://api.chucknorris.io";
        String statusCode = given().log().all().queryParam("category","explicit")
                .header("Content-Type","application/json")
                .get(baseURI + "/jokes/random")
                .getBody().jsonPath().get("value");

        System.out.println(statusCode);

    }
}
