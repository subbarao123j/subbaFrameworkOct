package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class PBDLogin {
	
	WebDriver driver;
	
	public PBDLogin(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	@FindBy(xpath="//input[contains(@name,'txtUsername')]") WebElement username;
	
	
	@FindBy(xpath="//input[contains(@name,'txtPassword')]") WebElement password;
	@FindBy(xpath="//input[@value='Login now']") WebElement loginButon;
	
	
	//a[text()='Employee Self Service']
	
	//id = username ..id = password ...id = clicklogin
	//*[@id="root"]/div[1]/div[3]/div/button[1]....createleave click
	
/*	public void validateHomePage()
	{
		Utility.validatingContainsTitle(driver, "psibusiness");
	}*/
	
	
	/*public void clearUserName()
	{
		System.out.println("LOG:INFO Username cleared");
		Utility.waitForWebElement(driver, username).clear();
	}*/

	public void enterUserName(String uname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, username).sendKeys(uname);
	}
	
	
/*	public void clearPassword()
	{
		System.out.println("LOG:INFO Password Cleared");
		Utility.waitForWebElement(driver, password).clear();
	}*/
	public void enterPassword(String pass)
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(pass);
	}
	
	
	public void enterUserName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,username).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 4, 0));
	}
	
	public void enterPassword()
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 4, 1));
	}
	
	
	
	public void clickLoginButton()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, loginButon);
		loginButon.click();
		
		
		
	}
	
	
}
