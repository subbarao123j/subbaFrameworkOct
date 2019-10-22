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
	@FindBy(xpath="//ul[(@id='businessUnit_listbox')]//li") WebElement bussDivDropDown;
	
	
	
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
	
	
	
	
	public void bussDiDropdownSel(String bussDivDropDown, String bu3)
	{
		Utility.waitForWebElement(driver, bussDiv);
		bussDiv.click();
		System.out.println("LOG: Clicked BusinessDivision Clicked "); 
		List<WebElement> listValues=driver.findElements(By.xpath(bussDivDropDown));
		System.out.println("Log:INFO- Total values are "+listValues.size());
		for(WebElement element:listValues)
		{
			String data=element.getText();
			if(data.equalsIgnoreCase(bu3))
			{
				element.click();
				break;
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
