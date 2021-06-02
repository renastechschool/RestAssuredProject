package stepDefinitions;

import POJO.PersonPOJO;
import POJO.SpeciesPOJO;
import groovyjarjarpicocli.CommandLine;
import io.restassured.response.Response;
import org.junit.Assert;
import utilies.ConfigurationsReader;

import static io.restassured.RestAssured.given;

public class ReusableMethodsSW {



    /**
     *
     * This method created by Erkan
     * This method created to GET all people information
     *
     * ***/
    public void getAllPeople(){

        Response response =
                given()
                .get(ConfigurationsReader.getProperties("BASE_URL")+"people");



        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());
    }




    public void getSpecificPerson(){

        Response response =
                given()
                .get(ConfigurationsReader.getProperties("BASE_URL") +"people/2"  );


        PersonPOJO person = response.body().as(PersonPOJO.class);

        System.out.println( "23 Person first Name is    "+person.getName());



        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());


        Assert.assertEquals("C-3PO",person.getName());

    }



    public void getAllSpecies(){
        Response response =
                given()
                .get(ConfigurationsReader.getProperties("BASE_URL") +"species/2"  );

        System.out.println(response.prettyPrint());
        System.out.println(response.statusCode());
        Assert.assertEquals(200,response.statusCode());


        SpeciesPOJO species = response.body().as(SpeciesPOJO.class);

       System.out.println("Species Eye Color is   "+ species.getAverage_lifespan());


    }











}
