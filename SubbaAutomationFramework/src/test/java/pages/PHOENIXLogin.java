package pages;


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
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, username).sendKeys(uname);
	}
	
	public void enterPassword(String pass)
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(pass);
	}
	
	
	public void enterUserName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,username).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 3, 0));
	}
	
	public void enterPassword()
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 3, 1));
	}
	
	
	
	public void clickLoginButton()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, loginButon);
		loginButon.click();
		
	}
	
	
}
