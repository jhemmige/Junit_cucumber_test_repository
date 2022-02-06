package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	//Step1: Create By Locators
	
	private By Email=By.id("Email");
	
	private By Password= By.id("Password");
	
	private By rememberMe = By.xpath("//*[@for='RememberMe'??]");
	//private By forgotPasswordlink = By.linkText("Forgot password?11");
	private By clickBtn= By.xpath("//*[@class='button-1 login-button']");
	
	
	//Step2: Create Constructor
	
	public LoginPage(WebDriver driver ){
		
		
		this.driver= driver;
	
		
	}
	
	//Step 3: Page Actions 
	
	public String getPageTitle() {
		
	String pageTitle=driver.getTitle();
	
	return pageTitle;
			
	}
	
	public  boolean rememberMeisDisplayed() {
		
		
	return	driver.findElement(rememberMe).isDisplayed();
		
	}
	
	
	public void enterEmail(String email)  {
		
	driver.findElement(Email).clear();
		
	driver.findElement(Email).sendKeys(email);
		
	}
	
	
	public void enterPassword(String pwd) {
		
		driver.findElement(Password).clear();
		
		driver.findElement(Password).sendKeys(pwd);
		
		
	}
	
	
	public void clickSubmit() {
		
		driver.findElement(clickBtn).click();
		
		
	}
	
	
	/**we are creating this method to combine the entire process of logging in one step. Basically one testcase should not depend on another. Hence we are creating 
	seperate case*/
	
	public AdminPage doLoging(String uname, String passwd) {
		
		
		
		driver.findElement(Email).clear();
		
		driver.findElement(Email).sendKeys(uname);
		
		driver.findElement(Password).clear();
		
		driver.findElement(Password).sendKeys(passwd);
		
		driver.findElement(clickBtn).click();
		
		return new AdminPage(driver); // This is called linking page. As we login from one page ( login page) , it'll return adminpage . Hence we are returning it.
		
		
	}
	

}
