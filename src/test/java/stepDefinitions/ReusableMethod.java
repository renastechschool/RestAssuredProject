package stepDefinitions;

import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;

import static io.restassured.RestAssured.given;

public class ReusableMethod {


    String BASE_URL = "http://qa-api.endamti.com/";


    public void getAClient(Integer id){


        Response response =

                given()
                .queryParam("id",590)
                .get(BASE_URL + "clients/get/");

        System.out.println("Status Code for Get Client: "+response.statusCode());

        System.out.println(response.prettyPrint());

//        if(id==591){
//            Assert.assertEquals(404,response.statusCode());
//        }else {
//            Assert.assertEquals(200,response.statusCode());
//        }



    }


    public void createNewUser(){

        JSONObject data = new JSONObject();

        data.put("active", true);
        data.put("balance", 0);
        data.put("canSms", true);
        data.put("city", "string");
        data.put("email", "string");
        data.put("entryDate", "string");
        data.put("firstname", "demo4");
        data.put("gender", "string");
        data.put("id", 509);
        data.put("internalId", "string");
        data.put("lastVisit", "string");
        data.put("lastname", "string");
        data.put("notificationBy", "string");
        data.put( "optIn", true);
        data.put("organization", "string");
        data.put( "otherPhone", "string");
        data.put("phone", "string");
        data.put("prefix", "string");
        data.put("state", "string");
        data.put("status", "pending");
        data.put("street", "string");
        data.put("title", "string");
        data.put("visits", 0);
        data.put("zip", "string");

        Response response =
                given()
                .contentType("application/json")
                .body(data)
                .post(BASE_URL+ "clients/add");

        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        Assert.assertEquals(200,response.statusCode());

    }



    public void activateTheUser(){

        // Create your response
        // verify your status code

        Response response =
                given()
                .queryParam("id",590)
                .put(BASE_URL + "clients/activate");

        System.out.println(response.statusCode());
        System.out.println(response.prettyPrint());

        Assert.assertEquals(200,response.statusCode());
    }


}
