package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubbapageCreate {
	
	WebDriver driver;
	
	
	public SubbapageCreate(WebDriver ldriver) 
	
	{
		this.driver=ldriver;
		
	}
	
	@FindBy (id="username") WebElement username;
	
	

}
