package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import helper.BaseClass;
import phoenixProject.PHOENIXAddCustomer;
import phoenixProject.PHOENIXLogOut;
import phoenixProject.PHOENIXLogin;

public class PHOENIXLoginTest extends BaseClass {

	PHOENIXLogin login;
	PHOENIXLogOut logOut;
	
	PHOENIXAddCustomer addCustomer;
	
	@Parameters({"username","password"})
	@Test(description="",priority=1)
	public void loginToPhoenix(String uname, String pass,String browser,String appURL) {

		login = PageFactory.initElements(driver, PHOENIXLogin.class);
		addCustomer = PageFactory.initElements(driver, PHOENIXAddCustomer.class);
		logOut = PageFactory.initElements(driver, PHOENIXLogOut.class);
		
		

		logger = report.createTest("Login Test for Phoenix");

		login.validateHomePage();

		logger.pass("Home Page Validated");
		
		login.enterUserName(uname);

		logger.info("Username entered");

		login.enterPassword(pass);

		logger.info("Password entered");

		login.clickLoginButton();

	logger.info("Clicked on Login button ");
	
	
	//Addcustomer
	
	addCustomer.customersMenuclick();
	
	logger.info("custmer name clicked");
	addCustomer.customersAddCompanyclick();
	
	
	addCustomer.enterCustomerName();
	logger.info("custmer name Added");
	
	addCustomer.enterCustomerCode();
	logger.info("custmer code Added");
	
	addCustomer.enterCustomerPentaCode();
	logger.info("custmer Pentacode  Added");
	
	addCustomer.savedClicked();
	
	
//Logout
		logOut.logoutFromApplication();

		logger.pass("User is able to logout");
	}


}
