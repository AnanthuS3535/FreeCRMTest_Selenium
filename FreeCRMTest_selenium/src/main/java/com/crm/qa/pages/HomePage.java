package com.crm.qa.pages;

import java.awt.Desktop.Action;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{
	
	TestUtil testutil;
	
	@FindBy(xpath="//td[contains(text(),'User: Ananthu S')]")
	WebElement userlabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement ContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement DealLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement TasksLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean verifyUserLabel(){
		 
		 return userlabel.isDisplayed();
	}
	
	public ContactsPage clickContactPage(){
		//ContactLink.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ContactLink);
		return new ContactsPage();
	}
	
	public DealsPage clickDealsPage(){
		DealLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickPage(){
		TasksLink.click();
		return new TasksPage();
	}
	
	public void newContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(ContactLink).build().perform();
		NewContact.click();
	}
	
	

}
