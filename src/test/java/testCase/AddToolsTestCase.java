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

public class AddToolsTestCase {
	WebDriver driver;
	JSONObject AddTools;
	
	@BeforeClass
	public void accessget() throws IOException
	{
		InputStream datais = null;
		
		try
		{
			String path = "Data/AddTools.json";
			datais= getClass().getClassLoader().getResourceAsStream(path);
			JSONTokener tok = new JSONTokener(datais);
			AddTools = new JSONObject(tok);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(datais!=null)
		{
			datais.close();
		}
		else
		{
			System.out.println("No data found!");
		}
	}
	//Pre-condition
	
	@BeforeMethod
	@Parameters
	public void setup(String browser, String url)
	{
		//
		
		driver = BrowserManager.getDriver(browser);
		driver.manage().window().maximize();
		
		driver.get(url);
	
	}
	
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	@Test
	
	public void valid_Data()
	{
		String Tool_Number=AddTools.getJSONObject("ValidData").getString("toolNo");
		String Tool_Name = AddTools.getJSONObject("ValidData").getString("toolName");
		String Tool_Make = AddTools.getJSONObject("ValidData").getString("toolMake");
		String Tool_Description = AddTools.getJSONObject("ValidData").getString("toolDesc");
		String Other = AddTools.getJSONObject("ValidData").getString("other");
		
		PO.AddTools obj = PageFactory.initElements(driver, PO.AddTools.class);
		
		obj.ValidData(Tool_Number,  Tool_Name, Other, Tool_Description, Tool_Description);
	}
	
	
	@Test
	
	public void invalid_data()
	{
		String Tool_Number=AddTools.getJSONObject("InvalidData").getString("toolNo");
		String Tool_Name = AddTools.getJSONObject("InvalidData").getString("toolName");
		String Tool_Make = AddTools.getJSONObject("InvalidData").getString("toolMake");
		String Tool_Description = AddTools.getJSONObject("InvalidData").getString("toolDesc");
		String Other = AddTools.getJSONObject("InvalidData").getString("other");
		
		PO.AddTools obj = PageFactory.initElements(driver, PO.AddTools.class);
		
		obj.ValidData(Tool_Number,  Tool_Name, Other, Tool_Description, Tool_Description);
	}
}