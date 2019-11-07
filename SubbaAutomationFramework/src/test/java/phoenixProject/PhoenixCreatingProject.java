package phoenixProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import dataProviderFactory.DataProviderFactory;
import helper.Utility;

public class PhoenixCreatingProject {
	
		
WebDriver driver;
	
	public PhoenixCreatingProject(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//*[contains(@class,'cui-briefcase')]") WebElement projectMenu;
	@FindBy(id="add-project") WebElement addProject;
	@FindBy(xpath="//*[contains(text(),'Division')]//following::span[1]") WebElement bussDiv;
	
	//@FindBy(xpath="//ul[(@id='businessUnit_listbox')]//li") WebElement bussDivDropDown;
	
	@FindBy(xpath="//*[contains(text(),'Operative')]//following::span[1]") WebElement operaUnit;
	@FindBy(xpath="//label[contains(text(),'Customer')]//following::span[1]") WebElement customer;
	@FindBy(xpath="//label[contains(text(),'End Customer')]//following::span[1]") WebElement endCustomer;
	@FindBy(xpath="//label[contains(text(),'INCO')]//following::span[1]") WebElement incoTerms;
	
	
	@FindBy(id="expectedStartDate") WebElement expStartDate;
	@FindBy(xpath="dateOfCompletion") WebElement dateCompletion;
	@FindBy(xpath="endOfWarranty") WebElement endWarranty;
	@FindBy(xpath="contractValue") WebElement contrtValue;
	@FindBy(xpath="engineeringHour") WebElement engineerHour;
	
	
	
	
	@FindBy(xpath="//label[contains(text(),'Contractual')]//following::span[1]") WebElement contCurrency;
	@FindBy(xpath="//label[contains(text(),'Local')]//following::span[1]") WebElement localCurrency;
	
	
	public void projectListPageValidation()
	{
	   Utility.validatingContainsTitle(driver, "PSI Incontrol Phoenix");
	}
	
	
	public void projectMenuClick()
	{
		Utility.waitForWebElement(driver, projectMenu);
		projectMenu.click();
		System.out.println("LOG: Clicked Project menu "); 
	}
	
	
	public void addProjectClick()
	{
		Utility.waitForWebElement(driver, addProject);
		addProject.click();
		System.out.println("LOG: Clicked Add Project Tab Clicked "); 
	}
	
	
	//Business Division
	
	public void bussDiDropdownSel(String bd)
	{
		Utility.waitForWebElement(driver, bussDiv);
		bussDiv.click();
		System.out.println("LOG: Clicked BusinessDivision Clicked "); 
		List<WebElement> bdValues=driver.findElements(By.xpath("//ul[(@id='businessUnit_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+bdValues.size());
		for(WebElement element:bdValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(bd))
			{
				element.click();
				break;
			}
		}
	}
	
	
	//Operative Unit
	
	public void operatingUnitClick(String ou)
	{
		Utility.waitForWebElement(driver, operaUnit);
		operaUnit.click();
		System.out.println("LOG: Clicked Operating Division Clicked "); 
		List<WebElement> ouValues=driver.findElements(By.xpath("//ul[(@id='operativeUnit_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+ouValues.size());
		for(WebElement element:ouValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(ou))
			{
				element.click();
				break;
			}
		}
	}
	
	
	
	//Expected Order Intake
	
	
	
	//Project Name
	
	//Project Code
	
	//SAGE Code
	
	
	//Customer
	public void customerClick(String cu)
	{
		Utility.waitForWebElement(driver, customer);
		customer.click();
		System.out.println("LOG: Clicked Operating Division Clicked "); 
		List<WebElement> cuValues=driver.findElements(By.xpath("//ul[(@id='customer_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+cuValues.size());
		for(WebElement element:cuValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(cu))
			{
				element.click();
				break;
			}
		}
	}
	
	
	
	//End Customer
	public void endCustomerClick(String cu)
	{
		Utility.waitForWebElement(driver, endCustomer);
		endCustomer.click();
		System.out.println("LOG: Clicked EndCustomer  Clicked "); 
		List<WebElement> endcuValues=driver.findElements(By.xpath("//ul[(@id='endCustomer_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+endcuValues.size());
		for(WebElement element:endcuValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(cu))
			{
				element.click();
				break;
			}
		}
	}
	
	//INCO Terms
	public void incoTermsClick(String cu)
	{
		Utility.waitForWebElement(driver, incoTerms);
		incoTerms.click();
		System.out.println("LOG: Clicked Operating Division Clicked "); 
		List<WebElement> incoTermsValues=driver.findElements(By.xpath("//ul[(@id='incoTerms_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+incoTermsValues.size());
		for(WebElement element:incoTermsValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(cu))
			{
				element.click();
				break;
			}
		}
	}
	
	//Expected Start Date
	public void enterExpectedStartdate  ()
	{
		
		//Utility.waitForWebElement(driver,enterExpectedStartdate).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
		System.out.println("LOG:INFO PentaCode Entered");
	}
	
	//Date Of Completion
	public void dateOfcompletion()
	{
		
		//Utility.waitForWebElement(driver,dateOfcompletion).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
		System.out.println("LOG:INFO PentaCode Entered");
	}
	
	//End of Warranty
	public void endOfWarrenty()
	{
		
		//Utility.waitForWebElement(driver,endOfWarrenty).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
		System.out.println("LOG:INFO PentaCode Entered");
	}
	
	//Contract Value
	public void contractValue()
	{
		
		//Utility.waitForWebElement(driver,customerPentaCode).sendKeys(DataProviderFactory.getExcel().getCellData("addCustomer", 1, 2));
		System.out.println("LOG:INFO PentaCode Entered");
	}
	
	//Engineering Hour rate
	public void engineeringHourrate()
	{
		
	}
	
	//Contractual Currency
	public void contractualCurrencyClick(String cu)
	{
		Utility.waitForWebElement(driver, customer);
		customer.click();
		System.out.println("LOG: Clicked Operating Division Clicked "); 
		List<WebElement> cuValues=driver.findElements(By.xpath("//ul[(@id='contractualCurrency_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+cuValues.size());
		for(WebElement element:cuValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(cu))
			{
				element.click();
				break;
			}
		}
	}
	
	//Local Currency
	public void localCurrencyClick(String cu)
	{
		Utility.waitForWebElement(driver, customer);
		customer.click();
		System.out.println("LOG: Clicked Operating Division Clicked "); 
		List<WebElement> loValues=driver.findElements(By.xpath("//ul[(@id='localCurrency_listbox')]//li"));
		System.out.println("Log:INFO- Total values are "+loValues.size());
		for(WebElement element:loValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(cu))
			{
				element.click();
				break;
			}
		}
	}
	
	//Exchange Rate
	
	
	//Save
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
