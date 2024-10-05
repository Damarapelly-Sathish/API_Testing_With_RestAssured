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
		nowPut();
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
	public static void postMethod1() {
		Map<String,String> h=new HashMap<String,String>();
		h.put("name", "sathish");
		h.put("email","sathishreddy2609@");
		JSONObject json=new JSONObject(h);
		given().body(json.toJSONString()).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		given().get("https://reqres.in/api/users/2").then().log().all();
	}
	public static void nowGet() {
		given().when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	public static void nowPut() {
		HashMap<String,String> h=new HashMap<String,String>();
		h.put("first_name","sathish");
		h.put("last_name","reddy");
		JSONObject json=new JSONObject(h);
		given().contentType("application/json").body(json.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200);
		given().contentType("application/json").when().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
	}
	
}
