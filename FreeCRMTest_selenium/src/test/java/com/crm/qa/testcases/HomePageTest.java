package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testutil;
	ContactsPage contactspage;

	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup(){
		initialization();
		testutil = new TestUtil();
		contactspage = new ContactsPage();
		loginpage = new LoginPage();
		homepage =loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		   homepage = new HomePage();
		   String homepageTitle = homepage.VerifyHomePageTitle();
		   Assert.assertEquals(homepageTitle, "CRMPRO", "Title not match");
		   
	}
	
	@Test(priority=2)
	public void verifyUserLabelTest(){
	   testutil.switchToFrame();
       Assert.assertTrue(homepage.verifyUserLabel());
	}
	
	@Test(priority=3)
	public void verifyContactsPage(){
		testutil.switchToFrame();
		contactspage = homepage.clickContactPage();
	}
	
	@Test(priority=4)
	 public void checkContactText(){
		  Assert.assertTrue(contactspage.verifyContactstText(),"Contact label is missing on this page ");
		  
	 }
	 
	 @Test(priority=5)
	 public void selectContactsbyNameTest(){
		 contactspage.selectContactsbyname("xxx xxx");
	 }
	
	@AfterMethod
	public void teardown(){
		driver.quit();
	}
}
