package PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddTools {

	@FindBy(how=How.XPATH, using="//input[@id='tool_no']")
	WebElement Tool_Number;
	
	@FindBy(how=How.XPATH, using="//input[@id='tool_name']")
	WebElement Tool_Name;
	
	@FindBy(how=How.XPATH, using="//input[@id='tool_name']")
	WebElement Tool_Make;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='tool_description']")
	WebElement Tool_Description;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='other']")
	WebElement Other;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-outline-primary float-right']")
	WebElement Add;
	
	public void EnterToolNumber(String ToolNumber)
	{
		Tool_Number.sendKeys(ToolNumber);
	}
	
	public void EnterToolName(String ToolName)
	{
		Tool_Name.sendKeys(ToolName);
	}
	
	public void EnterToolMake(String ToolMake)
	{
		Tool_Make.sendKeys(ToolMake);
	}
	
	public void EnterToolDescription(String ToolDescription)
	{
		Tool_Description.sendKeys(ToolDescription);
	}
	
	public void EnterOtherDescription(String OtherDescription)
	{
		Other.sendKeys(OtherDescription);
	}
	
	public void AddButton()
	{
		Add.click();
	}
	
	//Test Cases
	public void ValidData(String ToolNumber, String ToolName, String ToolMake, String ToolDescription, String OtherDescription)
	{
		try
		{
			EnterToolNumber(ToolNumber);
			Thread.sleep(1000);
			EnterToolName(ToolName);
			Thread.sleep(1000);
			EnterToolMake(ToolMake);
			Thread.sleep(1000);
			EnterToolDescription(ToolDescription);
			Thread.sleep(1000);
			AddButton();
			Thread.sleep(1000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void InvalidToolNumberOtherValidDetails(String ToolNumber, String ToolName, String ToolMake, String ToolDescription, String OtherDescription)
	{
		try
		{
			EnterToolNumber(ToolNumber);
			Thread.sleep(1000);
			EnterToolName(ToolName);
			Thread.sleep(1000);
			EnterToolMake(ToolMake);
			Thread.sleep(1000);
			EnterToolDescription(ToolDescription);
			Thread.sleep(1000);
			AddButton();
			Thread.sleep(1000);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}