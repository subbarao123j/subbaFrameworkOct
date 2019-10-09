package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PBDLogOut {

	WebDriver driver;
	
	public PBDLogOut(WebDriver ldriver)
	{
		this.driver=ldriver;
	}
	
	
	
	@FindBy(xpath="//a[text()='Logout']")
	WebElement logoutButton;
	
	public void logoutFromApplication()
	{
	
		logoutButton.click();
	}
	
	
}
