package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class DOMSLogin {
	
	WebDriver driver;
	
	public DOMSLogin(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	@FindBy(xpath="//a[text()='NORTHERN / EASTERN RCC']") WebElement region;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy(xpath="//button[text()='Log in']") WebElement loginButon;
	//By username=By.id("txtUsername");
	
	
	
	public void validateHomePage()
	{
		Utility.validatingContainsTitle(driver, "DISTRIBUTION");
	}
	
	

	public void clickregion()
	{
		System.out.println("LOG:INFO Clicked on Region button"); 
		Utility.waitForWebElement(driver, region);
		region.click();
		
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
		Utility.waitForWebElement(driver,username).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 2, 0));
	}
	
	public void enterPassword()
	{
		System.out.println("LOG:INFO Password Entered");
		Utility.waitForWebElement(driver, password).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 2, 1));
	}
	
	
	
	public void clickLoginButton()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, loginButon);
		loginButon.click();
		
	}
	
	
}
