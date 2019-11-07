package helper;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import org.testng.annotations.Parameters;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class BaseClass {
	
	public	WebDriver driver;
	public ExtentReports report;
	public ExtentTest logger;

	@BeforeSuite
	public void setupReport()
	{
		
		System.out.println("LOG:INFO- Before Suite Running- Setting up report");

		//ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/PHOENIX_"+Utility.getTime()+".html"));
		ExtentHtmlReporter reporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Report/PHOENIX.html"));

		report=new ExtentReports();
		report.attachReporter(reporter);
		
		System.out.println("LOG:INFO- After Suite Running- Reports are ready to use");

		
	}
	
	@Parameters({"myBrowser","URL"})
	@BeforeClass
		public void setupBrowsers(String myBrowser,String URL)
	{	
		System.out.println("LOG:INFO: Creating Browser Session");
		driver = BrowserFactory.startApplication(myBrowser,URL);
						
		System.out.println("LOG:INFO: Browser Session Created");
	}
	
	//DataProviderFactory.getConfig().getBrowser()
	//DataProviderFactory.getConfig().getStagingURL()
	
	@AfterMethod
	public void appendReport(ITestResult result)
	{
	
		System.out.println("Test Name "+result.getName());
		
		System.out.println("LOG:INFO- After method Running- Generating Test Report");
		
		int status=result.getStatus();
				
		if(status==ITestResult.SUCCESS)
		{
			try {
			
				logger.pass("Test Scenario Passed ",MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotBase64(driver)).build());
			} catch (IOException e) {
				System.out.println("Not able to attach Screenshot "+e.getMessage());
			}
		}
		else if(status==ITestResult.FAILURE)
		{
			try {
				//logger.fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(Utility.captureScreenshot(driver)).build());
				logger.fail("Test Failed "+result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromBase64String(Utility.captureScreenshotBase64(driver)).build());

			} catch (IOException e) {
				System.out.println("Not able to attach Screenshot "+e.getMessage());
			}
		}
		else if(status==ITestResult.SKIP)
		{
			logger.skip("Test Scenario Skipped");
		}
		
		report.flush();
		
		System.out.println("LOG:INFO- After method Executed- Test Result Appended to report");

	}
	
	
	@AfterClass
	public void closeSessions()
	{
		System.out.println("LOG:INFO: Closing Browser Sessions");
		driver.quit();
		System.out.println("LOG:INFO: Browser Session Closed");
	}
	
}
