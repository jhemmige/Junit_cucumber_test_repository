package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {
	
	WebDriver driver;
	
	//step1 : locator
	private By customersNav= By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]/a/p");
	
	//Step 2: Constructor
	
	public AdminPage (WebDriver driver) {
		
		this.driver= driver;

		
	}
	
	// Step 3: Action methods
	
	
	public void clickCustomersNav() {
		
		driver.findElement(customersNav).click();
		
		
	}
	
	
	public String getPageTitle() {
		
		
	return	driver.getTitle();
		
	}
	
	
	
	public ArrayList<String> getCustNavList() {
		
	List <WebElement> CustNavlist= driver.findElements
			(By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]/ul/li/a/p"));
	
	//List<String> arr = new ArrayList<String>();
	
	ArrayList<String> arr = new ArrayList<String>();
	for (WebElement e: CustNavlist) {
		
		String customernavtext = e.getText();
		System.out.println(e.getText());
			
			arr.add(customernavtext);
			
		}
	
	return arr;
	
	}
	
	
	public int getcustNavListsize() {
		
		List <WebElement> CustNavlist= driver.findElements
				(By.xpath("//ul[@class='nav nav-pills nav-sidebar flex-column nav-legacy']/li[4]/ul/li/a/p"));	
		int custNavListsize=CustNavlist.size();
		
		return custNavListsize;
		
	}
	

}
