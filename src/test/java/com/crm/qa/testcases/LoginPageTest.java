package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Testbase {
	LoginPage loginpage;
	HomePage homepage;
	 public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception {
		initialization();
		loginpage=new LoginPage();
		}
	
	@AfterMethod
	public  void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws Exception {
		
		String title=loginpage.ValidateLoginPagetitle();
		Assert.assertEquals(title, "Free CRM software in the cloud powers sales and customer service");
		}
	
	@Test(priority=2)
	public void CRMLogoImageTest() {
		boolean image=loginpage.ValidatecrmImage();
		Assert.assertTrue(image);
	}
	
	@Test(priority=3)
	public void LoginTest() throws Exception
	
	{
		Thread.sleep(4000);
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		
	}	

}
