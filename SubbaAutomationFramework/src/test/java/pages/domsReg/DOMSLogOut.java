package pages.domsReg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DOMSLogOut {

	WebDriver driver;
	
	public DOMSLogOut(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//*[text()='Logout']")
	WebElement logoutButton;
	
	public void logoutFromApplication()
	{
	
		logoutButton.click();
	}
	
	
}
