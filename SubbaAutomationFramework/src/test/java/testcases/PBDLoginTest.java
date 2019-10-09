package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import pages.PBDLogOut;
import pages.PBDLogin;
import pages.PHOENIXLogOut;
import pages.PHOENIXLogin;

public class PBDLoginTest extends BaseClass {

	PBDLogin login;
	PBDLogOut logOut;

	@Test(description="",priority=1)
	public void loginToPBD() {

		login = PageFactory.initElements(driver, PBDLogin.class);

		logOut = PageFactory.initElements(driver, PBDLogOut.class);

		logger = report.createTest("Login Test for PSI BUSINESS DESK");

		//login.validateHomePage();

		//logger.pass("Home Page Validated");
		
        //login.clearUserName();
         
		login.enterUserName();

		logger.info("Username entered");
		
		//login.clearPassword();

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
