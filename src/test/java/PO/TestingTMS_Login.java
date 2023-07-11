package PO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class TestingTMS_Login {

	WebDriver driver;
	
	public TestingTMS_Login(WebDriver driver)
	{
		this.driver = driver;
	}
	
	@FindBy(how=How.XPATH, using="//input[@id='siteengineer_email']")
	WebElement Txt_Login_Email;
	
	@FindBy(how=How.XPATH, using="//input[@id='siteengineer_password']")
	WebElement Txt_Login_Password;
	
	@FindBy(how=How.XPATH, using="//button[@type='submit']")
	WebElement Login_Btn;
	
	public void enterEmail(String email)
	{
		Txt_Login_Email.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		Txt_Login_Password.sendKeys(password);
	}
	
	public void button()
	{
		Login_Btn.click();
	}
	
	
	public void ValidUsernameValidPassword(String email, String password)
	{
		try
		{
			enterEmail(email);
			Thread.sleep(1000);
			enterPassword(password);
			Thread.sleep(1000);
			button();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void InvalidUsernameValidPassword(String email, String password)
	{
		try
		{
			enterEmail(email);
			Thread.sleep(1000);
			enterPassword(password);
			Thread.sleep(1000);
			button();
			Thread.sleep(1000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}