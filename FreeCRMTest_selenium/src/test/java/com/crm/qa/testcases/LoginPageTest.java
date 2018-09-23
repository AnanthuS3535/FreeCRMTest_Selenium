package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	 LoginPage loginpage;
	 HomePage homepage;
	 
	 public LoginPageTest(){
		 super();
	 }
	 
	 @BeforeMethod
	 public void setup(){

		 initialization();
		 loginpage = new LoginPage();
	 }
	 
	 @Test
	 public void logintest(){
		 homepage = loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
	 }
	 
	 @AfterMethod
	 public void teardown(){
		 driver.quit();
	 }

}
