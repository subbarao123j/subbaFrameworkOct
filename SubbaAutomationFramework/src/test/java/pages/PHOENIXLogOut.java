package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PHOENIXLogOut {

	WebDriver driver;
	
	public PHOENIXLogOut(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//*[contains(text(),'Logout')]")
	WebElement logoutButton;
	
	public void logoutFromApplication()
	{
	
		logoutButton.click();
	}
	
	
}
