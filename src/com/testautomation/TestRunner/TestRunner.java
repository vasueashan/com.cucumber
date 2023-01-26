package com.testautomation.TestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.gherkin.model.Scenario;

import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;
import cucumber.api.testng.TestNGCucumberRunner;
import cucumber.runtime.model.CucumberFeature.CucumberFeatureUriComparator;




@CucumberOptions(
		features = "./features",
		glue = {"com.testautomation.Stepdef"},
		tags = {"@UATTesting"},
		plugin = {"pretty","html:target/site/cucumber-pretty",
				"json:target/cucumber.json"},
		monochrome = true
		)

public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
		
	@BeforeClass(alwaysRun = true)
	public void setUpClass()
	{
		//step-1
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}
	
	
	@Test(dataProvider ="features")
	public void feature(PickleEventWrapper entwrapper,CucumberFeatureWrapper featureWapper) throws Throwable
	{//step-4
		//testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
		
		testNGCucumberRunner.runScenario(entwrapper.getPickleEvent());
	}
	
	@DataProvider
	public Object[][] features()
	{//step-2
				
		//return testNGCucumberRunner.provideFeatures();
		return testNGCucumberRunner.provideScenarios();
		
	}
	@AfterClass(alwaysRun = true)
	public void tearDownClass()
	{
		testNGCucumberRunner.finish();	
	}
	

}

