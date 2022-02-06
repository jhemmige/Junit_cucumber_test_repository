package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Customerpage {
	
	private	WebDriver driver;

	//Step1: Creating constructor

	public  Customerpage(WebDriver driver) {
		
		this.driver = driver;
		
		
	}
	
	
	//Step2: Adding page elements

	private By addNewBtn= By.xpath("//a[@class='btn btn-primary']");
	
	private By customersNav= By.xpath("//i[@class='nav-icon far fa-user']");
	private By successmsg = By.xpath("//div[@class='alert alert-success alert-dismissable']");
	private By lnkCustomers_menuitem=By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");
	
	
	
	
public void clickcustonMenuItem()  {
	
driver.findElement(customersNav).click();
//By lnkCustomers_menuitem=By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]");

/*List<WebElement>custmenuItem=driver.findElements(By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]/ul/li/a/p"));
		
		
for (WebElement e:custmenuItem ) {
	
	e.getText();
	
	
	if (e.getText().equalsIgnoreCase("Customers")) {
		
		
		e.click();
		
		*/
		
		
	}
	
	
public void clickcustomeronlist() {
	
	driver.findElement(lnkCustomers_menuitem).click();
	
	
	
			
}
		
		
	
	
	
	
	public AddNewCustomerPage click_add_new_btn() {
		
		
		driver.findElement(addNewBtn).click();
		
		return new AddNewCustomerPage(driver);
		
	}
	
	
	//this method is not used 
	/*public String getSuccessmsg( ) {
		
		
	return driver.findElement(successmsg).getText();
		
	
	
	}*/
	
	
	
}

