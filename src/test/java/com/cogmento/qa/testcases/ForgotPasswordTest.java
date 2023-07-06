package com.cogmento.qa.testcases;

import java.time.Duration;

import org.cogmento.qa.baseclass.BaseClass;
import org.cogmento.qa.pages.ForgotPasswordPage;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ForgotPasswordTest extends BaseClass {

	   ForgotPasswordPage forgotpasswordpage;
	   
	   @BeforeClass
		public void setUp(){
			initialization();
			forgotpasswordpage = new ForgotPasswordPage();
		}
	   
	  @Test(priority=1)
	   public void validatePassword() {
		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
	   forgotpasswordpage.forgotpass();
	   }
	  
	  @Test(priority=2)
	  public void validateEntermail() {
		  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		  forgotpasswordpage.entermailid(prop.getProperty("Entermail"));
		  }
	  
	  @Test(priority=3)
	  public void validateRestButton() {
		 forgotpasswordpage.clickRestpassword();
	  }
	  
	  @AfterClass
		public void teraDown() { 
		driver.quit();
		}
	  
}



