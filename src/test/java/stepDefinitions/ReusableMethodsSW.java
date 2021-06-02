package stepDefinitions;

import io.restassured.response.Response;
import org.junit.Assert;
import utilies.ConfigurationsReader;

import static io.restassured.RestAssured.given;

public class ReusableMethodsSW {



    public void getAllPeople(){

        Response response =
                given()
                .get(ConfigurationsReader.getProperties("BASE_URL")+"people");

        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());

        Assert.assertEquals(200,response.statusCode());


    }


    /**
     *
     * Crsate a method that get      /people/1
     *
     * Requirement
     *
     * 1. Create scenario
     * 2. Create steps definition
     * 3. Create reusable method
     *
     * **/

    // break until 8:10 pm






}
