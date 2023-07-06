package com.cogmento.qa.testcases;

import java.time.Duration;

import org.cogmento.qa.baseclass.BaseClass;
import org.cogmento.qa.pages.ContactsPage;
import org.cogmento.qa.pages.HomePage;
import org.cogmento.qa.pages.LoginPage;
import org.cogmento.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ContactsPageTest extends BaseClass{
	
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	
	public ContactsPageTest(){
		super();
	}
	

	@BeforeClass
	 public void setUp()
	{
		initialization();
		loginpage = new LoginPage();	
		homepage = new HomePage();
		contactspage = new ContactsPage();
		homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactspage = homepage.clickContacts();
	
	}
	
	@Test(priority=1)
	public void validateCreateContactsButton() throws InterruptedException {
	contactspage.createrecord();
	Thread.sleep(3000);
	}
	
	@Test(priority=2)
	public void validateCreateNewContract() {
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
	
	contactspage.createNewContacts("Ricky", "Adamn", "Martin", "Solve Pvt Ltd");
    }
	
	@Test(priority=3)
    public void validateFirstNameField() {
	contactspage.validateFirstNameField();
	    String actualerror = "The field First Name is required";
		String expectederror = "The field First Name is required";
		Assert.assertEquals(actualerror, expectederror);
	}
	
	@Test(priority=4)
	public void validateLastNameField()  {
		contactspage.validateLastNameField();
	    String actualerror = "The field Last Name is required";
		String expectederror = "The field Last Name is required";
		Assert.assertEquals(actualerror, expectederror);
 
	}
	
	
	
	@AfterClass
	public void teardown(ITestResult result) {
		
		if(ITestResult.FAILURE==result.getStatus())
		{
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}

//	
//	@Test(priority=8)
//	public void clickEditContacts() {
//		contactspage.clickEditButton();
//	}
//	
	
	
	
	
	
	
}
