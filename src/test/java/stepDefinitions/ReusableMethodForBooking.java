package stepDefinitions;

import POJO.TokenPojo;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import utilies.ConfigurationsReader;

import static io.restassured.RestAssured.given;

public class ReusableMethodForBooking {



    public String getToken(){

        JSONObject  json = new JSONObject();
        json.put("username" , "admin" );
        json.put("password" , "password123");


        Response response =

                given()
                .contentType("application/json")
                .body(json)
                .post(ConfigurationsReader.getProperties("BASE_URL_BOOKING")+ "auth");

        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        TokenPojo token = response.body().as(TokenPojo.class);
        String tokenForBooking = token.getToken();

        System.out.println("Token is   "+tokenForBooking);

        return tokenForBooking;
    }


    /**
     *     https://restful-booker.herokuapp.com/booking/1
     *    1) Send GET request
     *    2) contentType("application/json")
     *
     *
     *    Print Response
     *    Verify Status code as 200
     *
     *
     *
     *               7 Min
     */






}
