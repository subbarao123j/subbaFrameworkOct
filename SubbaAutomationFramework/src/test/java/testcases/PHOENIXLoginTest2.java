package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import phoenixProject.PHOENIXAddCustomer;
import phoenixProject.PHOENIXLogOut;
import phoenixProject.PHOENIXLogin;

public class PHOENIXLoginTest2 extends BaseClass {

	PHOENIXLogin login;
	
	
	PHOENIXAddCustomer addCustomer;

	@Test(description="LoginPhoenix",priority=1)
	public void loginToPHOENIX() {

		login = PageFactory.initElements(driver, PHOENIXLogin.class);
		
		
		logger = report.createTest("Login Test for Phoenix");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.enterUserName();

		logger.info("Username entered");

		login.enterPassword();

		logger.info("Password entered");

		login.clickLoginButton();

	logger.info("Clicked on Login button ");
	
	}
	
}
