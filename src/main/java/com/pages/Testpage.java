package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

@Test
public class Testpage {
	
	
	public void getCustomerList() throws InterruptedException {
		
		
		System.setProperty("webdriver.chrome.driver","/Users/jayashreehemmige/Documents/drivers/chromedriver");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		driver.findElement(By.id("Email")).clear();
		driver.findElement(By.id("Email")).sendKeys("admin@yourstore.com");
		driver.findElement(By.id("Password")).clear();
		driver.findElement(By.id("Password")).sendKeys("admin");
		driver.findElement(By.xpath("//*[@class='button-1 login-button']")).click();
		
		Thread.sleep(2000);
		
		
	
		
	driver.findElement(By.xpath("/html[1]/body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/a[1]/p[1]")).click();
		
	
	driver.findElement(By.xpath("//body[1]/div[3]/aside[1]/div[1]/div[4]/div[1]/div[1]/nav[1]/ul[1]/li[4]/ul[1]/li[1]/a[1]/p[1]")).click();

	driver.findElement(By.xpath("//a[@class='btn btn-primary']")).click();
	
driver.findElement(By.name("Email")).sendKeys("5@gmail.com");
	
	driver.findElement(By.xpath("//button[@name='save']")).click();
	
	String txt = driver.findElement(By.xpath("/html[1]/body[1]/div[3]/div[1]/div[1]")).getText();
	
	System.out.println("THis is the text " + txt);
	
	driver.close();
	//driver.findElement(By.xpath("//*[@class='k-widget k-multiselect k-multiselect-clearable']/div/input[1]")).click();
	
	//WebElement storeName =driver.findElement(By.xpath("//input[@class='k-input k-readonly']"));
	
	//storeName.click();
	//thread.sleep(2000);
	
	

	

/*for (int i=0;i<custlist.size(); i++) {
	
	System.out.println	(custlist.get(i).getText());
	
}*/
	




/*

Thread.sleep(2000);


String text = driver.findElement(By.xpath("//h1[@class='float-left']")).getText();
	
boolean boo= text.contains("Add a new customer back");	

System.out.println(boo);
		
	}*/


}
	
}

