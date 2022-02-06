package testRunners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	
		
	//features= "src/test/resources/Appfeatures",
	features="src/test/resources/Appfeatures/AddingCustomer.feature",
	
	//features= "src/test/resources/Appfeatures/AdministrationPagejunit.feature",
	glue = {"stepdefinitions","AppHooks"},
	dryRun= false, //before running the actual run, every step is created correctly
	monochrome= true, //removes unneccessary characters from console window. Refer to  "/Users/jayashreehemmige/Documents/Selenium/Selenium Hybrid Framework_youtube/malformed_characters_in_cucumber_test.png"
	plugin= {"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:", 
			"timeline:test-output-thread/"
			}
)
public class MyTestRunnerTest {

}
