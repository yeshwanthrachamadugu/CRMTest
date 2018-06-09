package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.Testbase;

public class ContactsPage extends Testbase {
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(name="first_name")
	WebElement Firstname;
	
	@FindBy(name="surname")
	WebElement Lastname;
	
	@FindBy(name="client_lookup")
	WebElement CompanyName;
	
	@FindBy(xpath="//input[contains(@type,'submit')]")
	WebElement saveButton;
	
	
	
	
	
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean VerifycontactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectcontactsByname(String name) {
		driver.findElement(By.xpath("xpath")).click();
		////*[@id="vContactsForm"]/table/tbody/tr[14]
		
	}
	
	public void createNewContact(String Title, String fName, String LName, String CompName) {
		
		Select select= new Select(driver.findElement(By.name("title")));
		select.selectByVisibleText(Title);
		Firstname.sendKeys(fName);
		Lastname.sendKeys(LName);
		CompanyName.sendKeys(CompName);
		saveButton.click();
		
		
		
		
		
		
	}
	
	
	

}
