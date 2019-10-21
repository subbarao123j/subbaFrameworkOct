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
	
	

	
	
	@FindBy(xpath="//a[contains(@href,'companies')]") WebElement customersMenu;
	
	@FindBy(xpath="//button[@id='add-company']") WebElement customersAdding;
	
	
	
	@FindBy(id="") WebElement  abc ;
		
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
		
		Utility.waitForWebElement(driver, customersMenu);
		customersMenu.click();
		System.out.println("LOG: Clicked Customer menu "); 
	}
	
	//add company
	public void customersAddCompanyclick()
	{
		; 
		Utility.waitForWebElement(driver, customersAdding);
		customersAdding.click();
		System.out.println("LOG:  adding clicked");
	}
	
	//Name
	
	public void enterCustomerName(String cname)
	{
		
		Utility.waitForWebElement(driver, customerName).sendKeys(cname);
		System.out.println("LOG:INFO Customer Name Entered");
	}
	
	public void enterCustomerName()
	{
		
		Utility.waitForWebElement(driver,customerName).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 0));
		System.out.println("LOG:INFO Customer Name Entered");
	}
	
	
	//Code
	
	public void enterCustomerCode(String cname)
	{
		System.out.println("LOG:INFO Customer code Entered");
		Utility.waitForWebElement(driver, customerCode).sendKeys(cname);
		System.out.println("LOG:INFO Customer code Entered");
	}
	
	public void enterCustomerCode()
	{
	
		Utility.waitForWebElement(driver,customerCode).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 1));
		System.out.println("LOG:INFO Customer code Entered");
	}
	//penta code
	
	public void enterCustomerPentaCode(String cname)
	{
		
		Utility.waitForWebElement(driver, customerPentaCode).sendKeys(cname);
		
		System.out.println("LOG:INFO PentaCode Entered");
	}
	
	public void enterCustomerPentaCode()
	{
		
		Utility.waitForWebElement(driver,customerPentaCode).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
		System.out.println("LOG:INFO PentaCode Entered");
	}
	//Save
	public void savedClicked()
	{
		 
		Utility.waitForWebElement(driver, customerSubmit);
		customerSubmit.click();
		System.out.println("LOG: Clicked adding clicked");
	}
	
			

	
	
}
