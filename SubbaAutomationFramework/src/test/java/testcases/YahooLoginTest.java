package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.YahooLogin;

public class YahooLoginTest extends BaseClass{
	
	
	YahooLogin yahlogin;
	
	@Test
	
	
	public void loginToYahooApp() {
		
		
		
		 yahlogin=PageFactory.initElements(driver, YahooLogin.class);
		 
		 logger = report.createTest("Login Test for Yahoo");
		 
		 //yahlogin.validateHomePage1();
		
		yahlogin.enterUserName();
		
		logger.info("Username entered");
		
		yahlogin.clickNext();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		
		}
		
		logger.info("Next clicked ");
	}
	
	
	
	
	

}
