package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import helper.BaseClass;
import phoenixProject.PHOENIXAddCustomer;
import phoenixProject.PHOENIXLogOut;
import phoenixProject.PHOENIXLogin;

public class PHOENIXAddCustomerLogout extends BaseClass {


	PHOENIXLogOut logOut;
	
	PHOENIXAddCustomer addCustomer;

	@Test   (dependsOnMethods="loginToPHOENIX")
	public void loginToDOMS() {

	
		
		addCustomer = PageFactory.initElements(driver, PHOENIXAddCustomer.class);
		

		logOut = PageFactory.initElements(driver, PHOENIXLogOut.class);

	

	

	
		
	
	
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
