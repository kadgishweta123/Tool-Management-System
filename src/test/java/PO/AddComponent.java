package PO;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddComponent {

	@FindBy(how=How.XPATH, using="//input[@id='tool_no']")
	WebElement Component_Name ;
	
	@FindBy(how=How.XPATH, using="//input[@id='tool_name']")
	WebElement Component_Code ;
	
	@FindBy(how=How.XPATH, using="//input[@id='tool_name']")
	WebElement Component_Material;
	
	@FindBy(how=How.XPATH, using="//textarea[@id='tool_description']")
	WebElement Component_Description;
	
	@FindBy(how=How.XPATH, using="//button[@class='btn btn-outline-primary float-right']")
	WebElement Add;
	
	public void enterComponentName(String componentname)
	{
		Component_Name .sendKeys(componentname);
	}
	
	public void enterComponentCode(String componentcode)
	{
		Component_Code.sendKeys(componentcode);
	}
	
	public void enterComponentMaterial(String componentmaterial)
	{
		Component_Material.sendKeys(componentmaterial);
	}
	
	public void enterComponentDescription(String componentdesc)
	{
		Component_Description.sendKeys(componentdesc);
	}
	public void Add()
	{
		Add.click();
	}
	
	public void ValidData(String componentname, String componentcode, String componentmaterial, String componentdesc)
	{
		try
		{
			enterComponentName(componentname);
			Thread.sleep(1000);
			enterComponentCode(componentcode);
			Thread.sleep(1000);
			enterComponentMaterial(componentmaterial);
			Thread.sleep(1000);
			enterComponentDescription(componentdesc);
			Thread.sleep(1000);
			Add();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void InvalidComponentNameOtherValidDetails(String componentname, String componentcode, String componentmaterial, String componentdesc)
	{
		try
		{
			enterComponentName(componentname);
			Thread.sleep(1000);
			enterComponentCode(componentcode);
			Thread.sleep(1000);
			enterComponentMaterial(componentmaterial);
			Thread.sleep(1000);
			enterComponentDescription(componentdesc);
			Thread.sleep(1000);
			Add();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}