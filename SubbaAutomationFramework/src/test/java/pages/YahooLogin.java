package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class YahooLogin {
	
	WebDriver driver;
	
	public YahooLogin(WebDriver ldriver) {
	
	this.driver=ldriver;
	
	}
	
	
	//@FindBy (id="login-username") WebElement username;
	
	@FindBy (xpath="//input[@value='Next']") WebElement next;
	
	
	By username = By.id("login-username");
	
	
	
	public void validateHomePage1()
	{
		Utility.validatingContainsTitle(driver, "Yahoo");
	}
	
	public void enterUserName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,username).sendKeys(DataProviderFactory.getExcel().getCellData("Login", 1, 0));
	}
	
public void clickNext() {
		
		next.click();
		
	}


	
	
	
}
