package phoenixProject;


import javax.swing.text.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class PHOENIXLogin {
	
	WebDriver driver;
	
	public PHOENIXLogin(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(className="btn") WebElement loginButon;
	
	
	
	
	public void validateHomePage()
	{
		Utility.validatingContainsTitle(driver, "PSI Incontrol - Login");
	}
	
	

	public void enterUserName(String uname)
	{
		System.out.println("LOG:INFO Username Trying to enter");
		Utility.waitForWebElement(driver, username).sendKeys(uname);
		System.out.println("LOG:INFO Username Entered");
	}
	
	public void enterPassword(String pass)
	{
		System.out.println("LOG:INFO Password Trying to enter");
		Utility.waitForWebElement(driver, password).sendKeys(pass);
		System.out.println("LOG:INFO Passworde Entered");
	}
	
	
	public void enterUserName()
	{
		
		//Utility.waitForWebElement(driver,username).sendKeys(DataProviderFactory.getExcel());
		System.out.println("LOG:INFO Username Entered");
	}
	
	public void enterPassword()
	{
		
		Utility.waitForWebElement(driver, password).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 3, 1));
		System.out.println("LOG:INFO Password Entered");
	}
	
	
	
	public void clickLoginButton()
	{
	
		Utility.waitForWebElement(driver, loginButon);
		loginButon.click();
		System.out.println("LOG:INFO Clicked on login button"); 
		
		
	}
	
	
}
