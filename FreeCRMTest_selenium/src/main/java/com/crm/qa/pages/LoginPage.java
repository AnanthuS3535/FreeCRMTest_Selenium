package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(name="username11")
	WebElement username;
	
	@FindBy(name="password11")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginbtn;
	
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	
	public HomePage Login(String un, String pwd){
		username.sendKeys(un);
		password.sendKeys(pwd);
		//loginbtn.click();
		
		JavascriptExecutor js =(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", loginbtn);
		
		return new HomePage();
		
    }
	
	

}
