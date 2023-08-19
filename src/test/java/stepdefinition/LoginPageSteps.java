package stepdefinition;

import org.junit.Assert;

import com.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	private LoginPage loginpage;


	
	@Given("user is on login page")
	public void user_is_on_login_page() {
		
		
	   
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ExpectedTitlestring) {
		String title=loginpage.getLoginPageTitle();
		System.out.println("page title is: "+title);
		Assert.assertTrue(title, false);
		
	}
	    

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user enters username {string}")
	public void user_enters_username(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user enters password {string}")
	public void user_enters_password(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("user gets the title of the home page")
	public void user_gets_the_title_of_the_home_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
