package com.testautomation.TestRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
		features = "./features",
		glue = {"com.testautomation.Stepdef"},
		tags = {"@Regression"},
		plugin = {"pretty","html:target/site/cucumber-pretty",
				"json:target/cucumber.json"},
		monochrome = true
		)


//@Listeners({ExtentITestListenerClassAdapter.class})
public class TestRunner2 extends AbstractTestNGCucumberTests {
	
	
	
	

}

