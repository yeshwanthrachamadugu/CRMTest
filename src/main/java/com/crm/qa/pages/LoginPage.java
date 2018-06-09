package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Testbase;

public class LoginPage extends Testbase {
	
	
	@FindBy(name="username") 
	WebElement username;
	
	@FindBy(name="password") 
	WebElement password;
	
	@FindBy(css=".btn.btn-small")
	WebElement loginbutton;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpbutton;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPagetitle() throws Exception
	{
		Thread.sleep(3000);
		String Title= driver.getTitle();
		return Title;
	}
	
	public boolean ValidatecrmImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage Login(String uName, String Password) throws Exception {
		username.sendKeys(uName);
		password.sendKeys(Password);
		Thread.sleep(3000);
		loginbutton.click();
		
		return new HomePage();
	}
	
    
	

}
