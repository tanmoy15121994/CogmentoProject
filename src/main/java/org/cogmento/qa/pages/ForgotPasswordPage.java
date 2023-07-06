package org.cogmento.qa.pages;

import org.cogmento.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage extends BaseClass{
	
	 // Initializing the Page Object
    public ForgotPasswordPage() 
    {
	 PageFactory.initElements(driver,this);	
    }
    
    @FindBy(xpath="//a[contains(@href,'password')]")
    WebElement forgotPassword; 
    
    @FindBy(xpath="//input[@name= 'email']")
    WebElement Entermail;
    
    @FindBy(xpath="//button[@name= 'action']")
    WebElement ResetPassword;
    
    
   	public ForgotPasswordPage forgotpass() {
   		forgotPassword.click();
   		return new ForgotPasswordPage();
   	}
   	
   	public void entermailid(String mail) {
   		Entermail.sendKeys(mail);
   		
   	}
   	
   	public void clickRestpassword() {
   		ResetPassword.click();
   	}
   	
}
