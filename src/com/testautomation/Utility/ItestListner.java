package com.testautomation.Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.testautomation.Stepdef.HookClass;
import com.testautomation.TestRunner.TestRunner;
import com.testautomation.TestRunner.TestRunner2;



public class ItestListner implements ITestListener {
	
	
	
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	public static ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		//step-3
//		String s = result.getMethod().getMethodName()+""+result.getTestName()+""+result.getTestClass().getName();
//    	 test =  extentReports.createTest(result.getMethod().getMethodName());
//		 extentTest.set(test);	
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		System.out.println("------->Test case Completed<--------");		
		
		//extentTest.get().pass(MarkupHelper.createLabel(TestRunner2.scenarioNam, ExtentColor.GREEN)) ;
		
		report = ExtentReportManager.getHRMInstance();
		test = report.createTest(HookClass.CurrentSenarioname);
		test.log(Status.PASS, "Successfully executed Scenario: "+HookClass.CurrentSenarioname);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		//System.out.println("------->Test case failed<--------");
		//extentTest.get().fail(MarkupHelper.createLabel(TestRunner2.scenarioNam, ExtentColor.RED)) ;
		StringBuilder sb = new StringBuilder();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("</head>");
		sb.append("<table>");
		sb.append("<th> Failed Step Method</th>");
		sb.append("<th> Failed Reason </th>");
		    sb.append("<tr>");
		    sb.append("<td> " + HookClass.CurrentMethodname + " </td>");
		    sb.append("<td> " + result.getThrowable() + " </td>");		    
		    sb.append("</tr>");		
		sb.append("</table>");
		sb.append("</body>");
		sb.append("</html>");
		
		//****************************************************
		report = ExtentReportManager.getHRMInstance();
		test = report.createTest(HookClass.CurrentSenarioname);
		//test.log(Status.FAIL,"Successfully not executed Scenario: "+"Failed Step " +HookClass.CurrentMethodname+"--"+"Failed Reason :"+result.getThrowable());
		test.log(Status.FAIL,"Successfully not executed Scenario: "+ sb.toString());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		report = ExtentReportManager.getHRMInstance();
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
//		System.out.println("------->Test case ended<--------");
//		if(extentReports !=null)
//			  extentReports.flush();
		
		report.flush();
		
	}

}
