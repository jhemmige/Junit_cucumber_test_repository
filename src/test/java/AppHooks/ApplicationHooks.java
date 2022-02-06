package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.primitives.Bytes;
import com.qa.Utils.ReadConfig;
import com.qa.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	
	private ReadConfig readconfig;
	private DriverFactory driverfactory;
	private WebDriver driver;
	Properties prop;
	
	@Before(order=0)
	public void getProperty() {
		
		readconfig= new ReadConfig();
		
		prop=readconfig.init_Properties();
		
		
	}
	@Before(order=1)
	public void launchBrowser() {
		
	String browserName=prop.getProperty("browser");
		driverfactory = new DriverFactory();
		driver=	driverfactory.init_driver(browserName);
		
		
	}
	
	@After (order=0)
	public void quitBrowser() {
		
		driver.quit();
		
	}
	
	@After(order=1)
	
	//scenario is an object of scenario
	//here we are taking the screenshot
	public void tearDown(Scenario scenario) {
		
		if (scenario.isFailed()) {
			
	String screenshotName=scenario.getName().replaceAll(" ", "_");
	byte[] sourcepath=	((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES); //we take outputtype as Byte instead of outputtype. file since it needs to get attached to extent report
	scenario.attach(sourcepath, "image/png", screenshotName);
			
			
			
		}
		
		
	}
	
	

}
