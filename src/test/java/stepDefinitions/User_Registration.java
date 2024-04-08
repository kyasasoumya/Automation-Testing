package stepDefinitions;

import java.util.List;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class User_Registration {
	@Given("User is on registration page")
	public void user_is_on_registration_page() {
	    System.out.println("user is in registration page");
	}

	@When("User gets list of users with specific details")
	public void user_gets_list_of_users_with_specific_details() {
	    System.out.println("User got list of users to be entered");
	}

	@Then("Enter all given details")
	public void enter_all_given_details(DataTable dataTable) {
		List<List<String>> userList =dataTable.asLists(String.class);
		for(List<String> users :userList) {
			System.out.println(users);
		}
	    
	}

	@Then("Users should be created successfully")
	public void users_should_be_created_successfully() {
	   System.out.println("Created users successfully");
	}

}
