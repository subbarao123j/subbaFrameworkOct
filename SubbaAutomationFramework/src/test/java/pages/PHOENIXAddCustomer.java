package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class PHOENIXAddCustomer {
	
	WebDriver driver;
	
	public PHOENIXAddCustomer(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	

	
	
	@FindBy(xpath="//a[contains(@href,'customers')]") WebElement customersMenu;
	
	@FindBy(xpath="//button[@id='add-company']") WebElement customersAdding;
	
	
		
	@FindBy(name="name") WebElement customerName;
	
	@FindBy(id="code") WebElement customerCode;
	
	@FindBy(id="pentaCode") WebElement customerPentaCode;
	
	
	
	@FindBy(xpath="//button[text()='Submit']") WebElement customerSubmit;
	
	 
	
	
	
	
	
	
	
	public void validateHomePage()
	{
		Utility.validatingContainsTitle(driver, "PSI Incontrol - Login");
	}
	
	//Customer menu
	
	public void customersMenuclick()
	{
		System.out.println("LOG: Clicked Customer menu "); 
		Utility.waitForWebElement(driver, customersMenu);
		customersMenu.click();
		
	}
	
	//add company
	public void customersAddCompanyclick()
	{
		System.out.println("LOG: Clicked adding clicked"); 
		Utility.waitForWebElement(driver, customersAdding);
		customersAdding.click();
		
	}
	
	//Name
	
	public void enterCustomerName(String cname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, customerName).sendKeys(cname);
	}
	
	public void enterCustomerName()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,customerName).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 0));
	}
	
	
	//Code
	
	public void enterCustomerCode(String cname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, customerCode).sendKeys(cname);
	}
	
	public void enterCustomerCode()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,customerCode).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 1));
	}
	//penta code
	
	public void enterCustomerPentaCode(String cname)
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver, customerPentaCode).sendKeys(cname);
	}
	
	public void enterCustomerPentaCode()
	{
		System.out.println("LOG:INFO Username Entered");
		Utility.waitForWebElement(driver,customerPentaCode).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
	}
	//Save
	public void savedClicked()
	{
		System.out.println("LOG: Clicked adding clicked"); 
		Utility.waitForWebElement(driver, customerSubmit);
		customerSubmit.click();
		
	}
	
			

	
	
}
