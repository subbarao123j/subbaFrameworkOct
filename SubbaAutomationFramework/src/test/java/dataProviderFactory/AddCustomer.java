package dataProviderFactory;

import java.awt.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class AddCustomer {

	static XSSFWorkbook wb;
	

	@Test
	//subba code
	public void addNewCustomer() throws InterruptedException {
		String arr1 []= {"BU3"};
		WebDriver driver;
		
		for(String name: arr1) {
		 wb = ExcelDataProvider.excelData(name);
		 
		System.setProperty("webdriver.chrome.driver", "D:\\SOFTWAARES-05082019\\77\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("http://10.9.80.189:9001/login");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("kul_subbarao");
		driver.findElement(By.id("password")).sendKeys("Subbarao1516");
		driver.findElement(By.className("btn")).click();
		

		
		
		
		for(int j=0;j<=wb.getNumberOfSheets()-1;j++) {
			Sheet st = wb.getSheetAt(j);
		  int  count = st.getPhysicalNumberOfRows();
		  for(int i=1;i<=count-1;i++)
		  {
		  
			  
			  Row r = st.getRow(i);
			  String[] s = null;
			
		       s= this.getBU3CustomerData(r);

//Adding Customer
		 
		     for(String val :s)
		     {
		    	 if (!val.isEmpty()&& !val.equalsIgnoreCase("")&& !val.equalsIgnoreCase(" "))
		    	 {
		       Thread.sleep(2000);
		 
			driver.findElement(By.xpath("//a[contains(@href,'customers')]")).click();
				
			driver.findElement(By.xpath("//button[@id='add-role']")).click();
			
			
//Customer  Form1
			   driver.findElement(By.xpath("//*[contains(text(),'Name')]//following::input[1]")).sendKeys(val);   
			
			   
//Customer  Form2
			driver.findElement(By.xpath("//*[contains(text(),'Name')]//following::input[2]")).sendKeys(val);
			
			
//Customer  Form3
			
			driver.findElement(By.xpath("//*[contains(text(),'Name')]//following::input[3]")).sendKeys(val);
			
//status
			
			
			WebElement dropdown = driver.findElement(By.xpath("//select[@class='form-control']"));
			
			Select sel = new Select(dropdown);
			
			sel.selectByVisibleText("Active");
			
			
// Submit	
			driver.findElement(By.xpath("//button[text()='Submit']")).click();
			
			
			Thread.sleep(1000);
			System.out.println("Customer has been added successfully under Customer Management");
			
			Thread.sleep(1000);
		
		  }
		  }
		}
		}
		}
}
	
	
	private String[] getBU3CustomerData(Row r) {

		String rowDataList ="";
		   String []arr=new String[2];
		   Cell c = r.getCell(1);
		   arr[0]=ExcelDataProvider.formTheListforAllCellsForString(c, rowDataList);
		   Cell c1 = r.getCell(2);
		   arr[1]= ExcelDataProvider.formTheListforAllCellsForString(c1, rowDataList);
		 		   
		   return arr;
		}
	
	

/*	private String[] getBU1CustomerData(Row r) {

		
			String rowDataList ="";
			   String []arr=new String[1];
			   Cell c = r.getCell(1);
			   arr[0]=ExcelDataProvider.formTheListforAllCellsForString(c, rowDataList);
			   return arr;
			
		
	}*/
		
}