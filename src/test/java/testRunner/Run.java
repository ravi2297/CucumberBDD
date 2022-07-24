package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions
					(
							
			features = ".//Features",
			glue = "stepdefinition",
		//	tags="@smoke and not @regression",
			monochrome = true,
			dryRun=false,
			plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
			//plugin = {"pretty","html:target/Cucumber Report/htmlreport.html",
		    //          "json:target/Cucumber Report/json.json"}

					)		


public class Run extends AbstractTestNGCucumberTests{

	// this class will be empty....
	// because runner class have no class definition
	
}
