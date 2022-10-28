package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class FreeCurrency {
    public static void main(String[] args) {
        String latest = "latest";
        RestAssured.baseURI = "https://api.freecurrencyapi.com/v1";
        getCurrencies(baseURI, latest);
    }

    public static void getCurrencies(String baseURI, String type){
        //Given, When and Then
        //https://api.freecurrencyapi.com/v1/latest?apikey=bW7UvfzxleKHXxPtegFh3dzzuiisnWXxYMUAzGbI&currencies=EUR%2CUSD%2CCAD

        JsonPath statusCode = given()
                .queryParam("apikey","bW7UvfzxleKHXxPtegFh3dzzuiisnWXxYMUAzGbI")
//                .queryParam("currencies","EUR,USD,CAD")
                .header("Content-Type","application/json")
                .get(baseURI + "/{param}", type)
                .getBody().jsonPath();

        Map<String, Float> data = statusCode.getMap("data");

        if (data != null) {
            for(String dato : data.keySet()){
                System.out.println(dato);
                System.out.println(data.get(dato));
            }

//            System.out.println(statusCode.prettify());
//            System.out.println(statusCode.getMap("data").size());
        }
    }
}
