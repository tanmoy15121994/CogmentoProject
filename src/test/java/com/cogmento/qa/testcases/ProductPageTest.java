package com.cogmento.qa.testcases;

import java.time.Duration;

import org.cogmento.qa.baseclass.BaseClass;
import org.cogmento.qa.pages.HomePage;
import org.cogmento.qa.pages.LoginPage;
import org.cogmento.qa.pages.ProductPage;
import org.cogmento.qa.utilities.TestUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ProductPageTest extends BaseClass {

	LoginPage loginpage;
	HomePage homepage;
	ProductPage productpage;

	public ProductPageTest() {
		super();
	}

	@BeforeClass
	public void setUp() throws InterruptedException {
		initialization();
		loginpage = new LoginPage();
		homepage = new HomePage();
		productpage = new ProductPage();
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		
		Thread.sleep(3000);

		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
	}

	@Test(priority = 1)
	public void validateNewbutton() {
		productpage.createNew();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
	}

	@Test(priority = 2)
	public void validateCreateNewProduct() {
		productpage.createNew();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3000));
		productpage.createNewProduct("Project", "New Project Created", "10", "55", "25", "50", "99", "Support");
	}

	@AfterClass
	public void teardown(ITestResult result) {

		if (ITestResult.FAILURE == result.getStatus()) {
			TestUtil.captureScreenshot(driver, result.getName());
		}
		driver.quit();
	}
}
