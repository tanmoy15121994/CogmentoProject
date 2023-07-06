package org.cogmento.qa.baseclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop;

	public BaseClass() {
		try {
			prop = new Properties();
			String projectpath = System.getProperty("user.dir");
			FileInputStream ip = new FileInputStream(projectpath + File.separator + "src" + File.separator + "main"
					+ File.separator + "java" + File.separator + "org" + File.separator + "cogmento" + File.separator
					+ "qa" + File.separator + "config" + File.separator + "config.properties");

			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if (browserName.equals("chrome")) {
		//	WebDriverManager.chromedriver().setup();
			// WebDriver driver= WebDriverManager.chromedriver().create();

			ChromeOptions options = new ChromeOptions();
			options.addArguments("-–remote-allow-origins=*");
			driver = new ChromeDriver(options);

			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

			driver.get(prop.getProperty("url"));

			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		}

	}
}
