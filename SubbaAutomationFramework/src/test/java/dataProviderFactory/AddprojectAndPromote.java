package dataProviderFactory;

import java.io.IOException;
//import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddprojectAndPromote {
	
	
	//@Test
	//subba code
	public void creatingProject() throws InterruptedException, IOException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\SOFTWAARES-05082019\\77\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("http://10.9.80.189:7777/login");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("kul_subbarao");
		driver.findElement(By.id("password")).sendKeys("Subbarao1516");
		driver.findElement(By.className("btn")).click();
		
		Thread.sleep(1000);
		 
		driver.findElement(By.xpath("//*[contains(@class,'cui-briefcase')]")).click();
		
		
		
		driver.findElement(By.id("add-project")).click();
		Thread.sleep(1000);
		///
		
		
		
		
		
		//Project Status
		
		WebElement pStatus = driver.findElement(By.xpath("//select[@id='projectStatus']"));
		
		Select sel = new Select(pStatus);
		
		sel.selectByVisibleText("Order");
		
		
				
		//Project Type
	

	WebElement pType = driver.findElement(By.xpath("//select[@id='projectType']"));
	
	Select sele = new Select(pType);
	
	sele.selectByVisibleText("Project");
	
		

 //Businessdivision
	

	WebElement bUnit = driver.findElement(By.id("businessUnit"));
	
	Select buni = new Select(bUnit);
	
	buni.selectByVisibleText("BU3");
	
	
	//Oerative Unit
	
WebElement oUnit = driver.findElement(By.id("operativeUnit"));
	
	Select oUni = new Select(oUnit);
	
	oUni.selectByVisibleText("Kuala Lumpur");
	
			
	//Expected OrderInTake
	
driver.findElement(By.xpath("//input[@id='expectedOrderIntake']")).sendKeys("23 December 2018");


//Mandatory & Unique Inputs

		
   driver.findElement(By.xpath("//input[@id='projectName']")).sendKeys("IT01_P0212");
	
	
   driver.findElement(By.xpath("//input[@id='projectCode']")).sendKeys("IT01_P0212");			

   driver.findElement(By.xpath("//input[@id='sageCode']")).sendKeys("IT01_P0212");   
 
   
   
   //Customer
   
   WebElement cust = driver.findElement(By.id("customer"));
	
	Select customer = new Select(cust);
	
	customer.selectByVisibleText("GE");

   
   
   
   //EndCustoemr

WebElement eCust = driver.findElement(By.id("endCustomer"));
	
	Select eCustomer = new Select(eCust);
	
	eCustomer.selectByVisibleText("GE");
   
   
Thread.sleep(1000);
   //INCO Terms


WebElement inCoTerms = driver.findElement(By.id("incoTerms"));

Select inCoTer = new Select(inCoTerms);

inCoTer.selectByVisibleText("Ex Work");





//Exp Start Date

Thread.sleep(1000);
   
   driver.findElement(By.id("expectedStartDate")).sendKeys("25 December 2018");
   
   //Date Of Compeletion
   
   driver.findElement(By.id("dateOfCompletion")).sendKeys("10 February 2020");
   
   //End of warranty
   
   driver.findElement(By.id("endOfWarranty")).sendKeys("10 February 2021");
   
   
   //Thread.sleep(2000);
   //C value
   
   driver.findElement(By.id("contractValue")).sendKeys("997998");
   
   driver.findElement(By.id("engineeringHour")).sendKeys("80");
   

   
   
   // C currency
   
   WebElement cCurren = driver.findElement(By.id("contractualCurrency"));

   Select cCurrency = new Select(cCurren);

   cCurrency.selectByVisibleText("MYR");
   
	



   
   //Local C
   WebElement lCurren = driver.findElement(By.id("localCurrency"));

   Select lCurrency = new Select(lCurren);

   lCurrency.selectByVisibleText("MYR");

Thread.sleep(1000);

   //Save
   
   driver.findElement(By.id("saveProjectButton")).click();
   Thread.sleep(1000);
   
   
   
   String c_url= driver.getCurrentUrl();
   
   if (c_url.contains("projects")) {
	   
	   System.out.println("Project has been saved Succesfully under Project List");
	
}
   else {
	   
	   System.out.println("Project Saving is UnSuccesful  under Project List");
   }
   
   
   
   Thread.sleep(3000);
   //Promote
   driver.findElement(By.xpath("//*[contains(text(),'IT01_P0212')]")).click();
   Thread.sleep(2000);
   
   driver.findElement(By.id("promote-project")).click();
   
   Thread.sleep(2000);


		
	 driver.findElement(By.xpath("//button[text()='OK']")).click();
	 Thread.sleep(5000);
   
	 driver.findElement(By.id("forecast-tab")).click();
	 
	 Thread.sleep(5000);
	 
	 
		
	   driver.findElement(By.xpath("//*[contains(text(),'IT01_P0212')]")).click();
	   Thread.sleep(5000);
	
	   driver.findElement(By.id("edit-project")).click();
   
	   Thread.sleep(5000);
	   
	   driver.findElement(By.xpath("//*[contains(text(),'Cost Table')]")).click();
	   
	   Thread.sleep(5000);
	   
	   driver.findElement(By.id("selectProjectCostTemplate")).click();
	   Thread.sleep(2000);
	   
	   driver.findElement(By.xpath("//span[text()='PSIINCO Cost Template 3.0']")).click();
	   
	   Thread.sleep(2000);
	   driver.findElement(By.xpath("//button[text()='Select']")).click();
	   
	   Thread.sleep(5000);
	   driver.findElement(By.id("saveProjectButton")).click();
	   
	   Thread.sleep(50000);
	   
	   
	   
	   driver.navigate().back();
	   Thread.sleep(5000);
	   driver.navigate().back();
	   Thread.sleep(5000);
	   
	   driver.findElement(By.id("forecast-tab")).click();
		 
		 Thread.sleep(5000);
		 
		 
			
		   driver.findElement(By.xpath("//*[contains(text(),'IT01_P0212')]")).click();
		   Thread.sleep(5000);
		   
		   driver.findElement(By.id("promote-project")).click();
		   
		   Thread.sleep(2000);
		   
		   driver.findElement(By.xpath("//button[text()='OK']")).click();
			 Thread.sleep(5000);
	   
	  	      
	   driver.findElement(By.id("active-tab")).click();
	   Thread.sleep(5000);
	   
	   driver.findElement(By.xpath("//*[contains(text(),'IT01_P0212')]")).click();
	   
	   Thread.sleep(5000);
	   
	   driver.findElement(By.id("edit-project")).click();
	   Thread.sleep(10000);
	   
	   driver.findElement(By.xpath("//*[contains(text(),'Cost Table')]")).click();
		 
		 Thread.sleep(5000);
		 
		 //Import
		 
		 driver.findElement(By.id("importButton")).click();
		 
		 Thread.sleep(5000);
		 
			
		 
		driver.findElement(By.xpath("//input[@class='custom-file-input']")).sendKeys("C:\\Users\\kul_subbarao\\Desktop\\Testing\\PCR_Import_IT01_P0290.xlsx");
		
		 driver.findElement(By.xpath("//button[text()='Show Data']")).click();
		 
		 Thread.sleep(70000);
		
		 driver.findElement(By.id("submit1")).click();
		

		 Thread.sleep(10000);
		 driver.findElement(By.id("submit2")).click();
		 
		 Thread.sleep(10000);
		 //driver.findElement(By.id("saveProjectButton")).click();
		 Thread.sleep(10000);
		 
		 
	}

}
