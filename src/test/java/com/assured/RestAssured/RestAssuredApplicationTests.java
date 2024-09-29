package com.assured.RestAssured;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*
;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
class RestAssuredApplicationTests {
	public static void main(String[] args) {
		Response response=RestAssured.get("https://jsonplaceholder.typicode.com/users");
		System.out.println(response.getBody().asString());
		postMethod();
		}
	public static void getMethod() {
		baseURI="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data[0].id",equalTo(7));
	}
	public static void postMethod() {
		Map<String,Object> data=new HashMap<String,Object>();
		JSONObject json1=new JSONObject(data);
		data.put("first_name", "sathish");
		data.put("last_name", "reddy");
		baseURI="https://reqres.in/api/users";
		given().body(json1.toJSONString()).when().post("/users").then().statusCode(201).log().all();
	}
}
