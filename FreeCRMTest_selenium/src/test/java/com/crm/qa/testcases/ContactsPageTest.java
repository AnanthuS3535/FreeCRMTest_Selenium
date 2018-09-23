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

public class ContactsPageTest extends TestBase {
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	TestUtil testutil;
	
	public ContactsPageTest(){
		 super();
	 }
	
	 @BeforeMethod 
	 public void setup(){
		 initialization();
		 testutil = new TestUtil();
		 loginpage = new LoginPage();
		 contactspage = new ContactsPage();
		 homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
		 testutil.switchToFrame();
		 contactspage = homepage.clickContactPage();
		 
		 
	 }
	 
	 @Test(priority=1)
	 public void checkContactText(){
		  Assert.assertTrue(contactspage.verifyContactstText(),"Contact label is missing on this page ");
		  
	 }
	 
	 @Test(priority=2)
	 public void selectContactsbyNameTest(){
		 contactspage.selectContactsbyname("xxx xxx");
	 }
	 
	 @Test(priority=3)
	 public void selectMultipleContactsTest(){
		 contactspage.selectContactsbyname("Ananthu S_01");
		 contactspage.selectContactsbyname("xxx xxx");
	 }
	 
	 @Test(priority=4)
	 public void createNewContact(){
		 homepage.newContactLink();
		 contactspage.NewContact("Mr.", "Ananthu", "S", "Pebble Creek");
	 }
	 
	 
	 @AfterMethod
	 public void teardown(){
		 driver.quit();
	 }
	 
	 

}
