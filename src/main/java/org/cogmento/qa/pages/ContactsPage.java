package org.cogmento.qa.pages;

import java.time.Duration;

import org.cogmento.qa.baseclass.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BaseClass {
	
	public ContactsPage() 
    {
	 PageFactory.initElements(driver,this);	
    }
	
	@FindBy(xpath="//a[@href ='/contacts/new']//parent::button[@class='ui linkedin button']")
	WebElement create;
	
	@FindBy(name ="first_name") 
	WebElement firstname; 
	
	@FindBy(name ="last_name")
	WebElement lastname;
	
	@FindBy(name ="middle_name")
	WebElement middlename;
	
	@FindBy(xpath ="//input[@class='search']")
	WebElement company;
	
	@FindBy(xpath ="//div[@class='four wide field']")
	WebElement access;
	
	@FindBy(xpath = "//i[@class='save icon']")
	WebElement save;
	
	public void createrecord() 
	{
		create.click();
	}
	
    public void createNewContacts(String fname, String lname, String mname, String cname) 
    {
    	firstname.sendKeys(fname);
    	lastname.sendKeys(lname);
    	middlename.sendKeys(mname);
    	company.sendKeys(cname);
		company.sendKeys(Keys.ENTER);
		access.click();
		save.click();
	}
	
	public void validateFirstNameField() 
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		save.click();
		driver.findElement(By.xpath("//span[text()='The field First Name is required']")).getText();
	}
	
	public void validateLastNameField()
	{
	   save.click();
	   driver.findElement(By.xpath("//span[text()='The field First Name is required']")).getText();	 
	}
	
}
	
	
	
	
	
	
	
	
	
	
	

//	
//	@FindBy(xpath= "//a[contains(@href,'/contacts/edit')]")
//	WebElement Edit;
//	
//	@FindBy(xpath="//div[@name= 'category']//preceding-sibling::i[@class='dropdown icon']")
//	WebElement category;	
//	
//	
//	public void clickEditButton() {
//		Edit.click();
//	}
//	
//	public void selectCategory() {
//		Select select = new Select(driver.findElement(By.xpath("//div[@name= 'category']")));
//		select.selectByVisibleText(null)
//	}

