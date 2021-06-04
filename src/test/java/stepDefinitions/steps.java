package stepDefinitions;

import io.cucumber.java.en.Given;

public class steps {

    ReusableMethod reusableMethod = new ReusableMethod();
    ReusableMethodsSW reusableMethodsSW = new ReusableMethodsSW();
    ReusableMethodForBooking booking = new ReusableMethodForBooking();

    @Given("The user wants to get client by id as {int}")
    public void the_user_wants_to_get_client_by_id_as(Integer id) {

        reusableMethod.getAClient(id);

    }

    @Given("The User wants create a new user")
    public void the_user_wants_create_a_new_user() {

        reusableMethod.createNewUser();
    }

    @Given("the user wants to activate")
    public void the_user_wants_to_activate() {
        reusableMethod.activateTheUser();
    }

    @Given("The user wants to get all people")
    public void the_user_wants_to_get_all_people() {

        reusableMethodsSW.getAllPeople();

    }

    @Given("The user wants to get a person")
    public void the_user_wants_to_get_a_person() {
         reusableMethodsSW.getSpecificPerson();
    }


    @Given("The user wants to get all Species")
    public void the_user_wants_to_get_all_species() {
         reusableMethodsSW.getAllSpecies();
    }


    @Given("The user wants to get second film")
    public void the_user_wants_to_get_second_film() {
        reusableMethodsSW.verifySpeciesForFilm2();
    }

    @Given("The user should be able to create a token")
    public void the_user_should_be_able_to_create_a_token() {
         booking.getToken();
    }

    @Given("The user wants to get booking")
    public void the_user_wants_to_get_booking() {
        booking.getBookingWithID();
    }

    @Given("The user wants to create a new booking")
    public void the_user_wants_to_create_a_new_booking() {
        booking.createNewBooking();
    }

}
