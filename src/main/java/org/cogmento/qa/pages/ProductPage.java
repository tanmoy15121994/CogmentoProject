package org.cogmento.qa.pages;

import org.cogmento.qa.baseclass.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BaseClass {
	
	public ProductPage() 
    {
	 PageFactory.initElements(driver,this);	
    }
	
	@FindBy(xpath = "//button[@class ='ui linkedin button']")
    WebElement newbutton;
	
	@FindBy(name ="name") 
	WebElement inputname; 
	
	@FindBy(name ="description") 
	WebElement inputdescription; 
	
	@FindBy(name ="sku") 
	WebElement inputsku; 
	
	@FindBy(name ="list_price") 
	WebElement listprice; 
	
	@FindBy(name ="wholesale_price") 
	WebElement wholesaleprice; 
	
	@FindBy(name ="sale_price") 
	WebElement saleprice; 
	
	@FindBy(name ="inventory") 
	WebElement inventory; 
	
//	@FindBy(xpath = "//div[@class='ui selection upward dropdown']") 
//	WebElement category; 
	
	@FindBy(xpath = "//button[@class ='ui linkedin button']")
	WebElement savebutton;
	
	public void createNew() {
		newbutton.click();
	}
	
	public void createNewProduct(String nme, String des, String sku, String lprice, String wprice, String sprice, String inv, String cat)
	{
		inputname.sendKeys(nme);
		inputdescription.sendKeys(des);
		inputsku.sendKeys(sku);
		listprice.sendKeys(lprice);
		wholesaleprice.sendKeys(wprice);
		saleprice.sendKeys(sprice);
		inventory.sendKeys(inv);
		
	}
	

	
	
	
	
	
	
	
	
	
	
}
