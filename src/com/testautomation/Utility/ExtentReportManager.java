package com.testautomation.Utility;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.markuputils.CodeLanguage;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;





public class ExtentReportManager {
	
	 public static ExtentReports extentReports;
	// public static ExtentHtmlReporter htmlReporter;
	 public static ExtentSparkReporter extentSparkReporter;
	public static ExtentReports getHRMInstance()
	   {
		   if(extentReports == null)			
			   createInstance();
		return extentReports;
		
		   
	   }
	
	public static String fullReportpath;
	public static ExtentReports createInstance()
	{
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime localDateTime =LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		String reportName = "TestReport"+ formattedTime + ".html";
		
		  fullReportpath = System.getProperty("user.dir")+"\\reports\\"+reportName;
		  extentReports = new ExtentReports();
		 extentSparkReporter = new ExtentSparkReporter(fullReportpath);
		extentSparkReporter.config().setReportName("Test API Automation Report");
		extentSparkReporter.config().setDocumentTitle("Test ExecutionReport");
		extentSparkReporter.config().setTheme(Theme.DARK);
		extentSparkReporter.config().setEncoding("uft-8");
		extentReports.attachReporter(extentSparkReporter);
		return extentReports;
		
		
	}
	
	public static String getReportNameWithTimeStamp()
	{
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy_MM_dd_HH_mm_ss");
		LocalDateTime localDateTime =LocalDateTime.now();
		String formattedTime = dateTimeFormatter.format(localDateTime);
		String reportName = "TestReport"+ formattedTime + ".html";
		return reportName;
		
		
	}
	
	

}
