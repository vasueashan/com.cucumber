package com.testautomation.Stepdef;

import org.testng.Assert;

import com.testautomation.Repository.loginPageRepository;
import com.testautomation.Utility.baseMethods;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class loginPage implements baseMethods {
	
	loginPageRepository objLogin = new loginPageRepository(HookClass.driver);
	
	@Given("Enter User name")
	public void enter_User_name() {
		HookClass.CurrentMethodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		INPUT_OBJ.loginUserID(objLogin.getloginUsername(), "vasu");
	}

	@Given("Enter pssword")
	public void enter_pssword() {
		HookClass.CurrentMethodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		INPUT_OBJ.loginPassword(objLogin.getloginpassword(), "vasu");
	}

	@When("Click on login button")
	public void click_on_login_button() {
		HookClass.CurrentMethodname = Thread.currentThread().getStackTrace()[1].getMethodName();
		INPUT_OBJ.loginBtn(objLogin.getloginLoginbtn());
	}

	@When("verify page title")
	public void verify_page_title() {
		HookClass.CurrentMethodname = Thread.currentThread().getStackTrace()[1].getMethodName();
	    Assert.assertEquals(HookClass.driver.getTitle(), "HRMS-Login");
	    
	}



}
