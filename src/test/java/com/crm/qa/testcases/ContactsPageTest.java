package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.Testbase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends Testbase{
	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	ContactsPage contactspage;
	String sheetName="contacts";
	
	 public ContactsPageTest() {
		super();
	}
	 
	
	@BeforeMethod
	public void setUp() throws Exception {
		
		initialization();
		testUtil= new TestUtil();
		contactspage= new ContactsPage();
		loginpage=new LoginPage();
		homepage=loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil.switchtoframe();
        contactspage=homepage.clickOnContactsLink();
		}
	
	@AfterMethod
	public  void tearDown() {
		driver.quit();
	}
	
	@Test(priority=1, enabled=false)
	public void verifycontactspagelabel() {
		Assert.assertTrue(contactspage.VerifycontactsLabel(),"Contacts label missing on the page");
	}
	
	@Test(priority=2,enabled=false)
	public void selectContactsTest() {
		contactspage.selectcontactsByname("Mukta Sharma");
	}
	
	@Test(priority=3, enabled=false)
	public void selectMultipleContactsTest() {
		contactspage.selectcontactsByname("Mukta Sharma");
		contactspage.selectcontactsByname("Rahul Dravid");
		contactspage.selectcontactsByname("Tom Peter");
	}
	
	@DataProvider
	public Object[][] getCRMTestData() throws Exception {
		return TestUtil.gettestData(sheetName);
		
		
	}
	@Test(dataProvider="getCRMTestData")
	public void validateCreatenewContact(String title, String firstname, String lastname, String company ) throws InterruptedException {
		homepage.clickonNewContactsList();
		Thread.sleep(2000);
		contactspage.createNewContact(title, firstname, lastname, company);
		
		
	}
	

}
