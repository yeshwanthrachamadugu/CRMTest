package com.crm.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

import junit.framework.Assert;

public class HomePageTest extends Testbase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage; 

	public HomePageTest() {

		super();
	}
	
	//testcases should be independent
    //before every tc launch browser and 

	@BeforeMethod
	public void setup() throws Exception
	{		
		initialization();
		testUtil= new TestUtil();
		contactspage= new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));

	}

	

	@Test(priority=1)
	public void VerifyHomePageTitle() {
		String HomepageTitle=homepage.VerifyHomePagetitle();
		Assert.assertEquals(HomepageTitle, "CRMPRO");
	}
   
	@Test(priority=2)
	public void verifyusernametest() {
		testUtil.switchtoframe();
		Assert.assertTrue(homepage.verifycorrectusername());
	}
	
	@Test(priority=3)
	public void VerifyContactsLinkTest() {
		testUtil.switchtoframe();
		contactspage=homepage.clickOnContactsLink();
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
   
	


}

