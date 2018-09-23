package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactslabel;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@type='submit' and @value='Save']")
	WebElement savebtn;
	
	
	public ContactsPage(){
		PageFactory.initElements(driver,this);
	}
	
	public boolean verifyContactstText(){
		return contactslabel.isDisplayed();
	}
	
	public void selectContactsbyname(String name){
		driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']//input[@type='checkbox' and @name='contact_id']")).click();
	}

	public void NewContact(String title,String first_name,String sur_name,String company_detail){
		Select select = new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(title);
		firstname.sendKeys(first_name);
		surname.sendKeys(sur_name);
		company.sendKeys(company_detail);
		savebtn.click();
		
		
	}

}
