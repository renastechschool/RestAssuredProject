package stepDefinitions;

import POJO.CreateBookingPojo;
import POJO.GetBookingWithIDPOJO;
import POJO.TokenPojo;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.junit.Assert;
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


    public void getBookingWithID(){


        Response response =
                given()
                .header("Accept","application/json")
                .get(ConfigurationsReader.getProperties("BASE_URL_BOOKING")+"booking/2");


        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        GetBookingWithIDPOJO  bookingWithID = response.body().as(GetBookingWithIDPOJO.class);

        System.out.println("Cehcking Date"+bookingWithID.getBookingdates().getCheckin());

    }


    /***
     *     /booking
     *
     *    The method POST
     *
     *    Content-Type: application/json'
     *
     *     The Body is
     *     You need to use JSONObject
     *     {
     *     "firstname" : "Jim",
     *     "lastname" : "Brown",
     *     "totalprice" : 111,
     *     "depositpaid" : true,
     *     "bookingdates" : {
     *         "checkin" : "2018-01-01",
     *         "checkout" : "2019-01-01"
     *     },
     *     "additionalneeds" : "Breakfast"
     *     }'
     *            until 9:10  pm
     * ***/


    public void createNewBooking(){


        JSONObject json = new JSONObject();
        json.put("firstname" , "Hasan");
        json.put("lastname","Champion");
        json.put("totalprice", 111);
        json.put("depositpaid" , true);
        json.put("additionalneeds" , "Breakfast");
        JSONObject json2 = new JSONObject();
        json2.put("checkin" , "2018-01-01");
        json2.put("checkout", "2019-01-01");
        json.put("bookingdates",json2);





        Response response =
                given()
                .header("Content-Type","application/json")
                .body(json)
                .post(ConfigurationsReader.getProperties("BASE_URL_BOOKING")+"booking");

        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        CreateBookingPojo bookingPojo = response.body().as(CreateBookingPojo.class);
        String checkigDate = bookingPojo.getBooking().getBookingdates().getCheckin();

        Assert.assertEquals("2018-01-01",checkigDate);

        String bookingID =  bookingPojo.getBookingid();

        if(bookingID == null){
            Assert.assertTrue(false);
        }



    }



}
