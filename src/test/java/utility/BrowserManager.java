package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserManager {

	public static WebDriver getDriver(String type)
	{
		WebDriver driver = null;
		if(type.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			
			//System.setProperty("web.driver.chrome", "C:\\Users\\Dell\\TestNG\\TMS_Testing_Project\\target\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		return driver;
	}

}