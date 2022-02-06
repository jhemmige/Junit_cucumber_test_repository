package stepdefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.pages.AddNewCustomerPage;
import com.pages.AdminPage;
import com.pages.Customerpage;
import com.qa.Utils.excelReader;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.*;
import junit.framework.Assert;

public class Add_New_customer_steps {

	Customerpage custpage = new Customerpage(DriverFactory.getDriver());
	AddNewCustomerPage Andp = new AddNewCustomerPage(DriverFactory.getDriver());
	AdminPage ap = new AdminPage(DriverFactory.getDriver());
	
	@When("user gets Customers section and clicks on Customers dropdown and clicks on Customers on the menu item")
	public void user_gets_customers_section_and_clicks_on_customers_dropdown_and_clicks_on_customers_on_the_menu_item() throws InterruptedException {
	
		custpage.clickcustonMenuItem();
		custpage.clickcustomeronlist();
		
		Thread.sleep(2000);
	}


	@When("user clicks on AddNew button")
	public void user_clicks_on_add_new_button() {
		custpage.click_add_new_btn();

	}

	@Then("{string} form is displayed")
	public void form_is_displayed(String expectedCustomerTitle) {
		
		String SplitActualtTitle= Andp.getCustomerTitle();
		String[] ActualTitle= SplitActualtTitle.split("back");
		String TrimmedActualTitle = ActualTitle[0].trim();
		
		System.out.println( "this is the actual title :" + TrimmedActualTitle);
		
		Assert.assertEquals(expectedCustomerTitle, TrimmedActualTitle);

		//Assert.assertTrue(ActualtTitle.contains(expectedCustomerTitle));

	}
	
	
	

	@When("user fills the form using excel sheet using {string} and rownumber {int}")
	public void user_fills_the_form_using_excel_sheet_using_and_rownumber(String SheetName, Integer RowNumber)
			throws InvalidFormatException, IOException, InterruptedException {

		excelReader er = new excelReader();
		List<Map<String, String>> testData = er.getData(
				"/Users/jayashreehemmige/Documents/Selenium/Selenium_projects_downloaded_from_Google/customertestdata.xlsx",
				SheetName);

		//String e_mail = testData.get(RowNumber).get("email");
		String RandomEmail = Andp.getRandomemail() + "@gmail.com";
		String pass_word = testData.get(RowNumber).get("password");
		String first_name = testData.get(RowNumber).get("firstname");
		String last_name = testData.get(RowNumber).get("lastname");
		String gen_der = testData.get(RowNumber).get("gender");
		String date_of_birth = testData.get(RowNumber).get("dataofbirth");
		String company_name = testData.get(RowNumber).get("companyname");
		String News_letter = testData.get(RowNumber).get("newsletter");
		String Customer_role = testData.get(RowNumber).get("customerrole");
		String Manager_of_vendor = testData.get(RowNumber).get("manager of vendor");
		String Admin_comment = testData.get(RowNumber).get("Admin comment");

		
		Andp.setemail(RandomEmail);
		Andp.setPassword(pass_word);
		Andp.setFname(first_name);
		Andp.setLname(last_name);
		Andp.setGender(gen_der);
		Andp.setDob(date_of_birth);
		Andp.setCompanyName(company_name);
		Andp.Newsletter(News_letter);
		Andp.setcustomerrole(Customer_role);
		Andp.manageVendor(Manager_of_vendor);
		Andp.setAdminComment(Admin_comment);
		
	}

	@When("clicks on Save button")
	public void clicks_on_save_button() throws InterruptedException {
		
		Andp.submitSavebtn();
		Thread.sleep(2000);

	}

	@Then("{string} message is displayed")
	public void message_is_displayed(String expectedmsgTitle) {
		
		
String Actualmsgtitle="The new customer has been added successfully.";

System.out.println ( "this is the Actualmsgtitle" + Actualmsgtitle);

Assert.assertEquals(expectedmsgTitle, Actualmsgtitle);


		

	}

}
