package basedObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentTest;

import commons.commonFuncs;
public class Obj_Login {

	// xpath
	String xpathHere = "//a[@href='http://demo.guru99.com/']";
	String xpathUserName = "//input[contains(@name,'uid')]";
	String xpathPassWord = "//input[contains(@name,'password_')]";
	String xpathLogin = "//input[contains(@name,'btnLogin')]";
	String xpathReset = "//input[contains(@name,'btnReset')]";
	commonFuncs func = new commonFuncs(); //new 1 constructor
	
	WebDriver local_driver; //hieu luc trong class obj_login
	
	//constructor : 
	public Obj_Login(WebDriver driver) {
		local_driver = driver;//gan gia tri cho local driver
	}
	// actions
	public void intput_username(ExtentTest test, String input_data) {
		func.element_sendkey(local_driver, test, xpathUserName, input_data);
	}

	public void intput_pwd(ExtentTest test,String input_data) {
		func.element_sendkey(local_driver, test, xpathPassWord, input_data);
	}

	public void click_login(ExtentTest test) {
		func.element_click(local_driver, test, xpathLogin);
	}

	public void click_reset(ExtentTest test) {
		func.element_click(local_driver, test, xpathReset);
	}

	public void click_here(ExtentTest test) {
		func.element_click(local_driver, test, xpathHere);
	}
}
