package stepDefinitions;

import POJO.FilmsPojo;
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


/**
 *
 * Task 2:
 *    1. Create a scenari get all Films
 *          - Print
 *          - Verify Status code as 200
 *   2. Create another scenario and get Films number 2
 *         - print
 *         - Verify status code as 200
 *         - Create POJO class
 *         - Verify all species as
 *                  "http://swapi.dev/api/species/1/",
 *                  "http://swapi.dev/api/species/2/",
 *                  "http://swapi.dev/api/species/3/",
 *                  "http://swapi.dev/api/species/6/",
 *                  "http://swapi.dev/api/species/7/" (edited)
 *
 * */





public void verifySpeciesForFilm2(){

    String[] expectedSpecies = {"http://swapi.dev/api/species/1/",
                                "http://swapi.dev/api/species/2/",
                                "http://swapi.dev/api/species/3/",
                                "http://swapi.dev/api/species/6/",
                                "http://swapi.dev/api/species/7/"};

    Response response =
            given()
            .get(ConfigurationsReader.getProperties("BASE_URL")+ "films/2");

    System.out.println(response.prettyPrint());
    System.out.println(response.statusCode());
    Assert.assertEquals(200,response.statusCode());


    FilmsPojo films = response.body().as(FilmsPojo.class);

    String[] actualSpecies = films.getSpecies();


    Assert.assertEquals(expectedSpecies,actualSpecies);

    for (int i=0; i<actualSpecies.length; i++){

        System.out.println("All species are special     :   "+actualSpecies[i]);

    }





}



}
