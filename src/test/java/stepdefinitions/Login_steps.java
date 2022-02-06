package stepdefinitions;

import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Login_steps {

	private LoginPage loginpage = new LoginPage(DriverFactory.getDriver());
	private static String pageTitle;

	@Given("user is on login page")
	public void user_is_on_login_page() {

		DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		pageTitle = loginpage.getPageTitle();
		System.out.println(pageTitle);

	}

	@Then("page title should be {string}")
	public void page_title_should_be(String ptitle) {

		Assert.assertTrue(pageTitle.contains(ptitle));

	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {

		Assert.assertTrue(loginpage.rememberMeisDisplayed());

	}

	@When("user enters username {string}")
	public void user_enters_username(String email) throws InterruptedException  {
		
		loginpage.enterEmail(email);

	}

	@When("user enters password {string}")
	public void user_enters_password(String pwd) {

		loginpage.enterPassword(pwd);
	}

	@When("user clicks on Login button")
	public void user_clicks_on_login_button() {
		loginpage.clickSubmit();

	}

}
