package org.example;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.Map;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LeagueOfLegendsAPI {
    public static void main(String[] args) {
        baseURI = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name";

        String myApi = "RGAPI-b6f78b14-8432-4944-98e6-6d3e6ef5d631";
        String summonerName = "holaestas";

        JsonPath statusCode = given()
                .queryParam("api_key",myApi)
                .header("Content-Type","application/json")
                .get(baseURI + "/{param}", summonerName)
                .getBody().jsonPath();

        Map<String, Object> data = statusCode.get();
        System.out.println(data);

        String accountId = statusCode.get("accountId");

        System.out.println(statusCode.prettify());
        System.out.println(accountId);


    }
}
