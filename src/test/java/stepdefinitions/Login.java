package stepdefinitions;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Step;
import pom.PomManager;

public class Login{
	private WebDriver driver;
	private PomManager p;
	
	private Hooks c;
	public Login(Hooks c) {
		System.out.println("**********Login constructor called**********");
		this.driver = c.getdriver();
		this.p = c.getPOM();
		this.c = c;
	}
	
	@Given("^User is on Landing Page$")
	public void user_is_on_landing_page(){
		p.getLoginPage().Launch();
		System.out.println("Application is Open at page "+ driver.getTitle());
		c.getScreenshot();
	}
	
	@When("^User Enter Username = \"([^\"]*)\" And Password = \"([^\"]*)\"")
	public void user_enter_username_pnd_password(String arg1, String arg2) {
		loginWithCredentials(arg1,arg2);
		System.out.println("Username password entered");		
		clickLoginButton();
	}

	@When("^User Enter Username = ([^\"]*) And Password = ([^\"]*)")
	public void user_enters_username_pnd_password(String arg1, String arg2) {
		loginWithCredentials(arg1,arg2);
		System.out.println("Username password entered");		
		clickLoginButton();		
	}

	@When("^User Enter Wrong Username And Password$")
	public void user_enter_wrong_username_pnd_password() {
		System.out.println("Entered Credentials");
		c.getScreenshot();		
	}

	@When("^Navigate HomePage to WebtablePage$")
	public void navigate_home_page_to_webtable_page() {
		p.getLoginPage().navigateToWebTable();
		c.getScreenshot();
	}

	@Then("^Homepage Is Displayed$")
	public void homepage_is_displayed() {

		System.out.println("Homepage is displayed");
		c.getScreenshot();
	}

	@Then("^Homepage Is Not Displayed$")
	public void homepage_is_not_displayed() {

	}

	@And("^Cards Are Displayed$")
	public void cards_are_displayed() {
		System.out.println("Cards displayed");
		c.getScreenshot();
	}

	@Step("User Enter Username and Password")
	public void loginWithCredentials(String arg1, String arg2) {
		p.getLoginPage().loginWithCredentials(arg1, arg2);	
		c.getScreenshot();
	}
	
	@Step("User Click on Login button")
	public void clickLoginButton() {
		p.getLoginPage().clickLoginButton();
		c.getScreenshot();
	}
}
