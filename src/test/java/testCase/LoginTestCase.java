package testCase;



import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import PO.TestingTMS_Login;
import utility.BrowserManager;



public class LoginTestCase {
	
	WebDriver driver;
	JSONObject Logintms;
	
	@BeforeClass
	public void accessget() throws Exception
	{
		InputStream datais = null;
		
		try
		{
			String path = "Data/Logintms.json";
			datais= getClass().getClassLoader().getResourceAsStream(path);
			JSONTokener tok = new JSONTokener(datais);
			Logintms = new JSONObject(tok);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
		if(datais!=null)
		{
			datais.close();
		}
		/*
		else
		{
			System.out.println("No data found!");
		}
		*/
		}
	}
	//Pre-condition
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void setup(String browser,String url) throws Exception
	{
		 driver = BrowserManager.getDriver(browser);
		 Thread.sleep(3000);
		 
		 driver.get(url);
		 Thread.sleep(1000);
		 
		 driver.manage().window().maximize();
		 Thread.sleep(1000);
		 
		 Thread.sleep(10000);
    }
	
	
	@Test
	public void valid_Data()
	{
		String email=Logintms.getJSONObject("ValidData").getString("Email");
		String password = Logintms.getJSONObject("ValidData").getString("Password");
		
	//  PO   Class  Name obj                                    PO Class Name with .class extention
		TestingTMS_Login obj = PageFactory.initElements(driver, TestingTMS_Login.class);
		
	// 		    name of method in PO    PO Variables -> email and password
		obj.ValidUsernameValidPassword(email, password);
	
	}
	
	
	@Test
	//           name of the method is given randomly
	public void Invalid_Data()
	{
		String email=Logintms.getJSONObject("InvalidData").getString("Email");
		String password = Logintms.getJSONObject("InvalidData").getString("Password");
		TestingTMS_Login obj = PageFactory.initElements(driver, TestingTMS_Login.class);
		obj.InvalidUsernameValidPassword(email, password);
	}
	
	
	
	@AfterMethod
	public void close()
	{
		// driver.quit();
	}
}