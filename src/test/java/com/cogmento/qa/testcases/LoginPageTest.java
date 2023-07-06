package com.cogmento.qa.testcases;

import java.time.Duration;
import org.cogmento.qa.baseclass.BaseClass;
import org.cogmento.qa.pages.HomePage;
import org.cogmento.qa.pages.LoginPage;
import org.cogmento.qa.utilities.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseClass {
	
	
	LoginPage loginpage;
	HomePage homepage;
	
		
	public LoginPageTest() {
     }
	
	@BeforeClass
	public void setUp(){
		initialization();
		loginpage = new LoginPage();
	}
	 
    @Test(priority=1)
    public void loginPageTitleTest() {
    String title = loginpage.validateLoginPageTitle();
    Assert.assertEquals(title, "Cogmento CRM");
    
    TestUtil.captureScreenshot(driver,"LoginPageTitle");
    }
	
 
   @Test(priority=2)
	public void loginTest() throws InterruptedException{
	
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	Thread.sleep(3000);
	
    TestUtil.captureScreenshot(driver,"LoginSuccessfull");
	}


	@AfterClass
	public void teraDown() {
	driver.quit();
	}
}
