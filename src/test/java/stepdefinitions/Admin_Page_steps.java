package stepdefinitions;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.pages.AdminPage;
import com.pages.LoginPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Admin_Page_steps {

	LoginPage lp = new LoginPage(DriverFactory.getDriver());

	private AdminPage aps;

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {

		//this is the way we use List map
		List<Map<String, String>> credentials = dataTable.asMaps();
		String username = credentials.get(0).get("username");
		String password = credentials.get(0).get("password");
		
		DriverFactory.getDriver().get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");

		aps = lp.doLoging(username,password);

	}

	@Given("user is on Admin page")
	public void user_is_on_admin_page() {

		String pageTitle = aps.getPageTitle();

		System.out.println(pageTitle);

	}

	@Then("user gets Customers section and clicks on Customers dropdown")
	public void user_gets_customers_section_and_clicks_on_customers_dropdown(DataTable expectedTableList) {

		aps.clickCustomersNav();

		List<String> expectedTablist = expectedTableList.asList(); // we are converting expectedTableList as List

		ArrayList<String> actualTableList = aps.getCustNavList();

		Assert.assertEquals(expectedTablist, actualTableList);
		//Assert.assertTrue(actualTableList.containsAll(actualTableList));

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedlistnumber) {

		int actualListnumber = aps.getcustNavListsize();

		Assert.assertTrue(actualListnumber == expectedlistnumber);

	}

}
