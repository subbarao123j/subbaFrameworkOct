package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class AddUserHRM {
	
	
WebDriver driver;
	
	public AddUserHRM(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	

	
	@FindBy(xpath="//a[@id='menu_admin_viewAdminModule']") WebElement admintab;
	
	@FindBy(id="btnAdd") WebElement add;
	
	@FindBy(id="systemUser_employeeName_empName") WebElement empName;
	
	@FindBy(id="systemUser_userName") WebElement usernameAddUser;
	
	@FindBy(id="systemUser_password") WebElement passwordAddUser;
	
	@FindBy(id="systemUser_confirmPassword") WebElement confirmpasswordAddUser;
	
	@FindBy(id="btnSave") WebElement save;
	
	
	
	public void clickadmintab()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, admintab);
		admintab.click();
		
	}
	
	public void clickadd()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, add);
		add.click();
		
	}
	
	
	
	public void employName(String uname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, empName).sendKeys("uname");
	}
	
	public void employName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,empName).sendKeys(DataProviderFactory.getExcel().getCellData("addUser", 1, 0));
	}
	
	
	public void employUserName(String uname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, usernameAddUser).sendKeys("uname");
	}
	
	public void employUserName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,usernameAddUser).sendKeys(DataProviderFactory.getExcel().getCellData("addUser", 2, 0));
	}
	
	
	public void employPassword(String uname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, passwordAddUser).sendKeys("uname");
	}
	
	public void employPassword()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,passwordAddUser).sendKeys(DataProviderFactory.getExcel().getCellData("addUser", 3, 0));
	}
	
	
	public void confirmPassword(String uname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, confirmpasswordAddUser).sendKeys("uname");
	}
	
	public void confirmPassword()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,confirmpasswordAddUser).sendKeys(DataProviderFactory.getExcel().getCellData("addUser", 4, 0));
	}
	
	
	public void saveUser()
	{
		System.out.println("LOG:INFO Clicked on login button"); 
		Utility.waitForWebElement(driver, save);
		save.click();
		
	}
	
	
	
	

}
