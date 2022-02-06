package com.pages;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage {
	
private	WebDriver driver;

//Step1: Creating constructor

public  AddNewCustomerPage(WebDriver driver) {
	
	this.driver = driver;
	
	
}

//Step 2: Adding Page objects/Elements

private By showcustTitle= By.xpath("//h1[@class='float-left']");

private By email = By.name("Email");
private By password = By.name("Password");
private By firstname= By.name("FirstName");
private By lastname= By.name("LastName");

private By genderM= By.xpath("//input[@id='Gender_Male']");
private By genderF = By.xpath("//input[@id='Gender_Female']");

private By dateOfBirth= By.xpath("//input[@id='DateOfBirth']");
private By companyName= By.xpath("//input[@id='Company']");
private By customerRole= By.xpath("/html[1]/body[1]/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[10]/div[2]/div[1]/div[1]/div[1]/div[1]");
//body/div[3]/div[1]/form[1]/section[1]/div[1]/div[1]/nop-cards[1]/nop-card[1]/div[1]/div[2]/div[9]/div[2]/div[1]/div[1]/div[1]/div[1]

private By NewsletterInput = By.xpath("//input[@class='k-input k-readonly']");
private By choosestorename= By.xpath("//li[contains(text(),'Your store name')]");
private By choosestorename1= By.xpath("//li[contains(text(),'Test store 2')]");

private By txtAdminContent=By.xpath("//textarea[@id='AdminComment']");

private By lstitemAdministrators=By.xpath("//li[contains(text(),'Administrators')]");
private By lstitemRegistered=By.xpath("//li[contains(text(),'Registered')]");
private By lstitemGuests=By.xpath("//li[contains(text(),'Guests')]");
private By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
private By lstitemforummderator= By.xpath("//li[contains(text(),'Forum Moderators')]");

//private By newsletterinputField= By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']");

private By btnSave=By.xpath("//button[@name='save']");


//Setting Gender
public String setGender( String gender) {
	
	
	if(gender.equalsIgnoreCase("Male")) {
		
		driver.findElement(genderM).click();
		
	}
	else if (gender.equalsIgnoreCase("Female")) {
		
		driver.findElement(genderF).click();
		
		
	}
	
	else {
		
		
		System.out.println("no gender to click found");
	}
	
		return gender;
	}

//Assert page title 
public String getCustomerTitle() {
	
return driver.findElement(showcustTitle).getText();
	

	
	
}


//Setting Newletter value
public String Newsletter(String value) throws InterruptedException {
	
	
driver.findElement(NewsletterInput).click();



Thread.sleep(2000);

if (value.equalsIgnoreCase("Your store name")){
	
	driver.findElement(choosestorename).click();
	
}

else if ( value.equalsIgnoreCase("Test store 2")) {
	
	driver.findElement(choosestorename1).click();
	
	
	
}


else {
	
	
	System.out.println("no store name chosen- please choose storename");
}
	
	return value;
	
}


//Setting ManageVendor

public String manageVendor (String textvalue) {
	
	
WebElement manageVend=driver.findElement(By.xpath("//select[@class='form-control']"));

Select mngvend = new Select(manageVend);

mngvend.selectByVisibleText(textvalue);
	
return textvalue;
	
}


//Setting CustomerRole

public String setcustomerrole(String role) throws InterruptedException {
	
	driver.findElement(customerRole).click();
	
	Thread.sleep(3000);
	
	if (role.contains("Administrators")) {
		
		driver.findElement(lstitemAdministrators).click();
	}
	else if (role.contains("Forum Moderators")) {
		
		
		driver.findElement(lstitemforummderator).click();
	}
	
	else if (role.contains("Vendors")) {
		
		driver.findElement(lstitemVendors).click();
		
	}
	else if (role.contains("Registered")) {
		
		driver.findElement(lstitemRegistered).click();
		
	}
	
	else {
		
		driver.findElement(lstitemGuests).click();
		
	}
	
	return role;
	
}

//Setting Email 
public void setemail(String Email) {
	
	
	driver.findElement(email).sendKeys(Email);
	
	
	
	
}

//Setting Password 
public void setPassword(String pwd) {
	
	
	driver.findElement(password).sendKeys(pwd);
	
	
}

//Setting FirstName 
public void setFname(String FirstName) {
	
	driver.findElement(firstname).sendKeys(FirstName);
	
	
}

//Setting LastName 
public void setLname(String LastName) {
	
	driver.findElement(lastname).sendKeys(LastName);
	
	
}

//Setting DateOfBirth 
public void setDob(String Dob) {
	
	driver.findElement(dateOfBirth).click();
	driver.findElement(dateOfBirth).sendKeys(Dob);
	
	
}

//Setting CompanyName 
public String setCompanyName(String Cname) {
	
	driver.findElement(companyName).sendKeys(Cname);
	
	return Cname;
}


public String setAdminComment(String AdminComment) {
	
	
	driver.findElement(txtAdminContent).sendKeys(AdminComment);
	
	return AdminComment;
	
	
}





public void submitSavebtn() {
	
	driver.findElement(btnSave).click();
	
	
}




public String getRandomemail() {
String RandomEmail= RandomStringUtils.randomAlphabetic(5);
	
	return RandomEmail;
}

	

}
