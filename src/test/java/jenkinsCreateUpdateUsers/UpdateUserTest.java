package jenkinsCreateUpdateUsers;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.LandingPage;
import pages.LoginPage;
import pages.ManagePage;
import pages.ManageUsersPage;

public class UpdateUserTest {
	
	WebDriver driver;
	
	@Before
	public void init() {
		driver = new ChromeDriver();
	}

	@Given("^I go to \"([^\"]*)\" website$")
	public void i_go_to_website(String website) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("http://localhost:8080/");
		LoginPage loginPage = new LoginPage(driver);
		assertTrue(loginPage.areWeThereYet());
		
		loginPage.clickLogIn("NTortImp", "alG20$m$x2BvG^X^NAa3");
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.clickManageJenkins();
		ManagePage managePage = new ManagePage(driver);
		managePage.clickManageUsers();
		
		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
		assertTrue(manageUsersPage.areWeThereYet());
	}

	@Given("^the username is present \"([^\"]*)\"$")
	public void the_username_is_present(String username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
		assertTrue(manageUsersPage.findParticularUser(username));
	}

	@When("^I click on username \"([^\"]*)\"$")
	public void i_click_on_username(String username) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		
		ManageUsersPage manageUsersPage = new ManageUsersPage(driver);
		manageUsersPage.clickUserName(username);
	}

	@When("^I click on configure link$")
	public void i_click_on_configure_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	    
	}

	@When("^change the current fullname to new a new fullname \"([^\"]*)\"$")
	public void change_the_current_fullname_to_new_a_new_fullname(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click save button$")
	public void i_click_save_button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^I click on People link$")
	public void i_click_on_People_link() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^the new fullname \"([^\"]*)\" should be visible for the username \"([^\"]*)\"$")
	public void the_new_fullname_should_be_visible_for_the_username(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	
	
}
