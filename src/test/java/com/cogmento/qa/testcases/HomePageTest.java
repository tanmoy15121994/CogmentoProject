package com.cogmento.qa.testcases;

import java.time.Duration;
import org.cogmento.qa.baseclass.BaseClass;
import org.cogmento.qa.pages.CompaniesPage;
import org.cogmento.qa.pages.ContactsPage;
import org.cogmento.qa.pages.HomePage;
import org.cogmento.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
	LoginPage loginpage;
	HomePage homepage;
	ContactsPage contactspage;
	CompaniesPage companiespage;

	
	public HomePageTest(){
		super();
	}
	

	@BeforeClass
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
		contactspage = new ContactsPage();
		companiespage = new CompaniesPage();
		homepage =  loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
    @Test(priority =0)
    public void verifyHomePageTitle() {
    	String homePageTitle = homepage.verifyHomePageTitle();
    	Assert.assertEquals(homePageTitle, "Cogmento CRM","Home Page Title is Invalid");
    }
    
    @Test(priority =1)   
    public void verifyUserName() {
    	Assert.assertTrue(	homepage.verifyPageUsername());
    }
    
    @Test(priority =2)   
    public void verifyContactsPage() {
    	contactspage = homepage.clickContacts();
    }
    
    @Test(priority =3)  
    public void verifyCompaniesPage() {
    	companiespage = homepage.clickCompanies();
    }
    
	
    @AfterClass
    public void teraDown() {
	driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(8000));
	driver.quit();
	}
		
}
		
	



