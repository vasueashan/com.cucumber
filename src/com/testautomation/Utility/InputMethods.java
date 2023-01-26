package com.testautomation.Utility;

import org.openqa.selenium.WebElement;

public class InputMethods {
	
	private WebElement element = null;
	private static InputMethods object = null;
	
	
	private InputMethods()
	{		}
	
	public static InputMethods getInsatnce()
	{
		if(object == null)
		{object = new InputMethods();}
		return object;
	}
	
public void loginUserID(WebElement element,String text)
{
	element.sendKeys(text);
}
public void loginPassword(WebElement element,String text)
{
	element.sendKeys(text);
}
public void loginBtn(WebElement element)
{
	element.click(); 
}

}
