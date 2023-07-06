package org.cogmento.qa.pages;

import java.time.Duration;

import org.cogmento.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BaseClass { 
	
    //pageFatcory
	
	@FindBy(xpath="//input[@name='email']") 
	WebElement username; 
	
	@FindBy(xpath ="//input[@name='password']") 
	WebElement password;
	
    @FindBy(xpath="//div[contains(@class, 'submit button')]")
    WebElement loginButton;
    
    @FindBy(xpath="//a[contains(@href,'password')]")
    WebElement forgotPassword; 
    
     // Initializing the Page Object
     public LoginPage() 
     {
 	 PageFactory.initElements(driver,this);	
     }
     
     //Actions
     
     public String validateLoginPageTitle() {
    	 return driver.getTitle();
     }
     
	 public HomePage login(String uname, String pass) {
		
		username.sendKeys(uname);
		password.sendKeys(pass);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		loginButton.click();
		
		return new HomePage();	
	}
	
}



	
