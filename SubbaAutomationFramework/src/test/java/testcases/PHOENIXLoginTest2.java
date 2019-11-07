package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.BaseClass;
import phoenixProject.PHOENIXAddCustomer;
import phoenixProject.PHOENIXLogOut;
import phoenixProject.PHOENIXLogin;

public class PHOENIXLoginTest2 extends BaseClass {

	PHOENIXLogin login;
	PHOENIXLogOut logOut;
	

	@Parameters({"username","password"})
	@Test(description="LoginPhoenix",priority=1)
	public void loginToPHOENIX(String uname, String pname)
	{

		login = PageFactory.initElements(driver, PHOENIXLogin.class);
		logOut = PageFactory.initElements(driver, PHOENIXLogOut.class);
		
		
		logger = report.createTest("Login Test for Phoenix");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.enterUserName(uname);

		logger.info("Username entered");

		login.enterPassword(pname);

		logger.info("Password entered");

		login.clickLoginButton();

	logger.info("Clicked on Login button ");
	
	//Logout
			logOut.logoutFromApplication();

			logger.pass("User is able to logout");
	
	}
	
}
