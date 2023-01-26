package com.testautomation.Repository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.Utility.BasedataFile;

public class loginPageRepository {
	
private static WebDriver ldriver;
	
    public loginPageRepository(WebDriver rdriver)
    {  	ldriver = rdriver;
    	PageFactory.initElements(rdriver, this);    	
    } 
    
    @FindBy(xpath = "//input[@name='txtUserId']")
    private static WebElement loginUsername;    
    public static WebElement getloginUsername()
    {    	return loginUsername;
    }
    
    @FindBy(xpath = "//input[@name='txtPassword']")
    private static WebElement loginpassword;    
    public static WebElement getloginpassword()
    {    	return loginpassword;
    }
    
    @FindBy(xpath = "//input[@name='ibtnEnter']")
    private static WebElement loginLoginbtn;    
    public static WebElement getloginLoginbtn()
    {    	return loginLoginbtn;
    }

}
