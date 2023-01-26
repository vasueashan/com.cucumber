package com.testautomation.Utility;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasedataFile {
	
	private static WebDriver driver;
	private static BasedataFile object = null;
	private BasedataFile()
	{		}
	
	public static BasedataFile getInsatnce()
	{
		if(object == null)
		{object = new BasedataFile();}
		return object;
	}
	
	
	public static WebDriver DriverSetup()
	{
		try
		{
			
			
	        //System.setProperty("webdriver.chrome.driver","F:\\Drivers\\chromedriver_win32_2.46\\chromedriver.exe");	
			//System.setProperty("webdriver.chrome.driver",ChrmPath);
			WebDriverManager.chromedriver().setup();
	        ChromeOptions options = new ChromeOptions();			
			options.setExperimentalOption("useAutomationExtension", false);// it will hide browser popub instead of this --disable-infobars in 76 chrom version
			options.setExperimentalOption("excludeSwitches",
			Collections.singletonList("enable-automation"));//// it will hide browser popub instead of this --disable-infobars in 76 chrom version
			Map<String, Object> prefs = new HashMap<String, Object>();//// it will hide browser pusername and pasword popub instead of this -disable-save-password-bubble in 76 chrom version
			prefs.put("credentials_enable_service", false);
			prefs.put("profile.password_manager_enabled", false);
			options.setExperimentalOption("prefs", prefs);//// it will hide browser pusername and pasword popub instead of this -disable-save-password-bubble in 76 chrom version
			//options.addArguments("--disable-save-password-bubble","false");
	        options.addArguments("--disable-extensions");
	        options.addArguments("no-sandbox");
	        options.addArguments("start-maximized");
			 driver = new ChromeDriver();
			 driver.manage().window().maximize();			 
		 driver.get("http://hrms.karnataka.gov.in/");		 
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return driver;
	}

	
    public static void driverShutDown()
    {
    	driver.close();
    	driver.quit();
    }

}
