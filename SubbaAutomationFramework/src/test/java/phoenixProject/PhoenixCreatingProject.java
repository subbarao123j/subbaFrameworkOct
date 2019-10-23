package phoenixProject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
	
	
	
	
	
	
	
	
	
	
	
	
	

}
