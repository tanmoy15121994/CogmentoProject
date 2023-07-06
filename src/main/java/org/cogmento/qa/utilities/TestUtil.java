package org.cogmento.qa.utilities;

import java.io.File;
import org.apache.commons.io.FileUtils;
import org.cogmento.qa.baseclass.BaseClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class TestUtil extends BaseClass {
	
	public static long PAGE_LOAD_TIMEOUT =20;
	public static long IMPLICIT_WAIT =10;
	
	public static void captureScreenshot(WebDriver driver, String screenshotName)
	{
		try 
		{
			TakesScreenshot Takescreen = (TakesScreenshot)driver;
			File source = Takescreen.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+screenshotName+".png"));
			System.out.println("Screenshot taken");
		} 
	    catch (Exception e) 
		{
			System.out.println("Exception while Taking Screenshot "+e.getMessage());
		} 
    }
	
	
	
}
