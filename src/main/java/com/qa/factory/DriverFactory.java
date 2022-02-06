package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tldriver = new ThreadLocal<WebDriver>();
	
	/**
	 * this method is used to initialize threadlocal driver using browser as parameter and this will return tldriver. THreadlocal
	 * basically helps in parallel execution
	 * 
	 * @param browser
	 * @return
	 */
	public WebDriver init_driver(String browser) {
		
		System.out.println("value of browser" + browser);
		if (browser.equals("chrome")) {
			
		WebDriverManager.chromedriver().setup();
		tldriver.set(new ChromeDriver());
		
		
		}
		
		else if 
		
		(browser.equals("firefox")){
			
			
			WebDriverManager.firefoxdriver().setup();	
			tldriver.set(new FirefoxDriver());
			
			
		}
		
		
		else if 
		
		(browser.equals("safari")){
				
			tldriver.set(new SafariDriver());
			
		}
		
		
		else {
			
			System.out.println("printing the other browser" + browser);
		
		
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		
		return getDriver(); // if we are returning getDriver, and getDriver is returning tldriver, then return type of above method also should be webdriver
		
		
	}
	
	//synchronized is the keyword used for parallel execution 
	//This method is used to get Threadlocal
	public static synchronized WebDriver getDriver() {
		
		return tldriver.get();
		
		
		
	}
	
	
	

}
