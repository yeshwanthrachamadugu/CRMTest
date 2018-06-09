package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class HomePage extends Testbase{
	
	@FindBy(xpath="//font[contains(text(),'User: Naveen K')]")
	@CacheLookup	//Performance of script will be improved.
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(), 'Contacts')]")
	@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Deals')]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(), 'Tasks')]")
	WebElement taskLink;
	
	@FindBy(xpath="//a[text()='New Contact']")
	WebElement Newcontactlink;
	
	
	public HomePage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePagetitle() {
		return driver.getTitle();
		
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage ClickOnDealslink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage ClickOnTaskslink() {
		taskLink.click();
		return new TasksPage();
	}
	public boolean verifycorrectusername() {
		return userNameLabel.isDisplayed();
		
	}
	public void clickonNewContactsList() {
		Actions acts= new Actions(driver);
		acts.moveToElement(contactsLink).build().perform();
		Newcontactlink.click();
		
	}

}
