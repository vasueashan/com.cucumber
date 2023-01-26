package com.testautomation.Stepdef;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.testautomation.Utility.ExtentReportManager;
import com.testautomation.Utility.baseMethods;

import cucumber.api.PickleStepTestStep;
import cucumber.api.Scenario;
import cucumber.api.event.TestStepStarted;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookClass implements baseMethods {
	
	public static String CurrentMethodname ;
	public static ExtentReports report;
	public static ExtentTest test;
	public static String CurrentSenarioname;
	public static WebDriver driver;
		
	@Before
	public void m1(Scenario scenario)
	{		
		CurrentSenarioname = scenario.getName();
		driver = MainDrivers.DriverSetup();
	}
	
	@After(order = 1)
	public void m2()
	{
		
		System.out.println("close driver");
		MainDrivers.driverShutDown();
	}
	
	@After(order = 2)
	public void m3(Scenario scenario)
	{
		if(scenario.isFailed())
		{			
		//System.out.println("take screen short"+CurrentMethodname);	
//		report = ExtentReportManager.getHRMInstance();
//		test = report.createTest(scenario.getName());
//		test.log(Status.FAIL,CurrentMethodname);
		
		}else
		{
//			report = ExtentReportManager.getHRMInstance();
//			test = report.createTest(scenario.getName());
//			test.log(Status.PASS, "URL open successfully");
		}
	}
	
	
	

}
