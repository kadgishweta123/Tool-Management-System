package testCase;

import java.io.IOException;
import java.io.InputStream;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import utility.BrowserManager;

public class AddComponentTestCase {
	
	WebDriver driver;
	JSONObject AddComponent;
	
	@BeforeClass
	public void accessget() throws IOException
	{
		InputStream datais = null;
		
		try
		{
			String path = "Data//AddComponent.json";
			datais= getClass().getClassLoader().getResourceAsStream(path);
			JSONTokener tok = new JSONTokener(datais);
			AddComponent = new JSONObject(tok);
			
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
		public void setup(String browser,String url) throws InterruptedException
		{
			 driver = BrowserManager.getDriver(browser);
			 Thread.sleep(3000);
			 
			 driver.get(url);
			 Thread.sleep(1000);
			 
			 driver.manage().window().maximize();
			 Thread.sleep(1000);
			 
			 Thread.sleep(1000);
	     }
		
		@Test
		public void ValidData()
		{
			
			String componentname = AddComponent.getJSONObject("ValidData").getString("componentName");
			String componentcode = AddComponent.getJSONObject("ValidData").getString("componentcode");
			String componentmaterial = AddComponent.getJSONObject("ValidData").getString("componentmaterial");
			String componentdesc = AddComponent.getJSONObject("ValidData").getString("componentdesc");
			
			PO.AddComponent obj = PageFactory.initElements(driver, PO.AddComponent.class);
			
			obj.ValidData(componentname, componentcode, componentmaterial, componentdesc);
		}
		
		@Test
		public void InvalidData()
		{
			String componentname = AddComponent.getJSONObject("InvalidData").getString("componentName");
			String componentcode = AddComponent.getJSONObject("InvalidData").getString("componentcode");
			String componentmaterial = AddComponent.getJSONObject("InvalidData").getString("componentmaterial");
			String componentdesc = AddComponent.getJSONObject("InvalidData").getString("componentdesc");
			
			PO.AddComponent obj = PageFactory.initElements(driver, PO.AddComponent.class);
			
			obj.InvalidComponentNameOtherValidDetails(componentname, componentcode, componentmaterial, componentdesc);
		}
		
		@AfterMethod
		public void close()
		{
			driver.quit();
		}

}