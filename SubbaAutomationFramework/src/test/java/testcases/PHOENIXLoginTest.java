package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;

import pages.PHOENIXLogOut;
import pages.PHOENIXLogin;

public class PHOENIXLoginTest extends BaseClass {

	PHOENIXLogin login;
	PHOENIXLogOut logOut;

	@Test(description="",priority=1)
	public void loginToDOMS() {

		login = PageFactory.initElements(driver, PHOENIXLogin.class);

		logOut = PageFactory.initElements(driver, PHOENIXLogOut.class);

		logger = report.createTest("Login Test for Phoenix");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.enterUserName();

		logger.info("Username entered");

		login.enterPassword();

		logger.info("Password entered");

		login.clickLoginButton();

	logger.info("Clicked on Login button ");

		logOut.logoutFromApplication();

		logger.pass("User is able to logout");
	}

	/*@Test(description="This test will add trainer")
	public void addTrainer() 
	{

	}*/

}
