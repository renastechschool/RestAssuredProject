package stepDefinitions;

import io.cucumber.java.en.Given;

public class steps {

    ReusableMethod reusableMethod = new ReusableMethod();

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

}
