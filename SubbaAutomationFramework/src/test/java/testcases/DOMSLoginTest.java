package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.DOMSLogOut;
import pages.DOMSLogin;
import pages.LogOut;
import pages.Login;

public class DOMSLoginTest extends BaseClass {

	DOMSLogin login;
	DOMSLogOut logOut;
	
	@Parameters({"username","password","myBrowser","URL"})

	@Test(description="",priority=1)
	public void loginToDOMS() {

		login = PageFactory.initElements(driver, DOMSLogin.class);

		logOut = PageFactory.initElements(driver, DOMSLogOut.class);

		logger = report.createTest("Login Test for DOMS");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.clickregion();

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
