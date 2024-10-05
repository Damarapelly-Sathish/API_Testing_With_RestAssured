package com.assured.RestAssured;

import java.util.HashMap;

import org.json.simple.JSONObject;


import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;   

public class JusPay {
	   static String userName="DBFE184C9A846D6A33AC063B40C605";
	   static String password="";
 public static void main(String[] args) {
	 postMethod();
 }
 public static void postMethod() {
	 HashMap<String,String> h=new HashMap<String,String>();
	 h.put("mobile_number","9988776655");
	 h.put("object", "customer");
	 h.put("object_reference_id", "sat@21345721356751232111");
	 h.put("first_name","sathish");
	 h.put("last_name","reddy");
	 JSONObject json=new JSONObject(h);
	 given().auth().preemptive().basic(userName,password).contentType("application/json").body(json.toJSONString()).when().post("https://sandbox.juspay.in/customers").then().statusCode(200).body("first_name",equalTo("sathish"));
 }
 public static void getMethod() {
	 given().auth().preemptive().basic(userName,password).when().get("https://sandbox.juspay.in/customers/sat@21345721357751232111?options.get_client_auth_token=true").then().statusCode(200).log().all();
 }

}
