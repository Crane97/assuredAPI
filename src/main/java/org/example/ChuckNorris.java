package org.example;

import io.restassured.RestAssured;

import java.util.List;

import static io.restassured.RestAssured.*;

public class ChuckNorris {
    public static void main(String[] args) {

        getAllCategories();
        getChuckJoke();
    }

    public static void getChuckJoke(){
        RestAssured.baseURI = "https://api.chucknorris.io";
        String statusCode = given().queryParam("category","animal")
                .header("Content-Type","application/json")
                .get(baseURI + "/jokes/random")
                .getBody().jsonPath().get("value");

        System.out.println("");
        System.out.println("El chiste de Chuck Norris de categoría explícita: ");
        System.out.println(statusCode);
    }

    public static void getAllCategories(){
        String response;

        RestAssured.baseURI = "https://api.chucknorris.io";
        List<String> statusCode = given()
                .header("Content-Type","application/json")
                .get(baseURI + "/jokes/categories")
                .getBody().jsonPath().get();

        System.out.println("All categories: ");
        for(String cat : statusCode) {
            System.out.print(cat + ", ");
        }
    }
}