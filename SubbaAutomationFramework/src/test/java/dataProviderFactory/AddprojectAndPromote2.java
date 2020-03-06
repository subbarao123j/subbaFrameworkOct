package dataProviderFactory;

import java.io.IOException;
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

public class AddprojectAndPromote2 {
	
	
	@Test
	//subba code
	public void creatingProject() throws InterruptedException, IOException {
		
		WebDriver driver;
		
		System.setProperty("webdriver.chrome.driver", "D:\\SOFTWAARES-05082019\\77\\chromedriver_win32\\chromedriver.exe");
		driver= new ChromeDriver();
		
	driver.manage().window().maximize();
		
		//driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		
		driver.get("http://10.9.80.189:9001/login");
		
		System.out.println(driver.getTitle());
		
		driver.findElement(By.id("username")).sendKeys("kul_subbarao");
		driver.findElement(By.id("password")).sendKeys("Subbarao1516");
		driver.findElement(By.className("btn")).click();
		
		Thread.sleep(1000);
		 
		driver.findElement(By.xpath("//*[contains(@class,'cui-briefcase')]")).click();
		
		
		
    

   
   
  
	 
	 driver.findElement(By.id("forecast-tab")).click();
	 Thread.sleep(5000);
	
	 List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"forecast-project-grid\"]/div[2]/table/tbody/tr/td[2]"));
	 Thread.sleep(5000);
	 for(WebElement element :tableRows)
		{

			try {
				driver.findElement(By.id("forecast-tab")).click();
				Thread.sleep(5000);

				List<WebElement> tableRows2 = driver
						.findElements(By.xpath("//*[@id=\"forecast-project-grid\"]/div[2]/table/tbody/tr/td[2]"));

				Thread.sleep(5000);
				tableRows2.get(0).click();
				Thread.sleep(5000);

				driver.findElement(By.id("edit-project")).click();

				Thread.sleep(5000);

				driver.findElement(By.xpath("//*[contains(text(),'Cost Table')]")).click();

				Thread.sleep(5000);

				try {

					driver.findElement(By.id("selectProjectCostTemplate")).click();
					Thread.sleep(2000);

					driver.findElement(By.xpath("//span[text()='PSIINCO Cost Template 3.0']")).click();

					Thread.sleep(2000);
					driver.findElement(By.xpath("//button[text()='Select']")).click();
				} catch (Exception e) {
					e.printStackTrace();
				}

				Thread.sleep(5000);
				driver.findElement(By.id("saveProjectButton")).click();

				Thread.sleep(50000);

				driver.navigate().back();
				Thread.sleep(5000);
				driver.navigate().back();
				Thread.sleep(5000);

				driver.findElement(By.id("forecast-tab")).click();

				Thread.sleep(5000);
				List<WebElement> tableRows1 = driver
						.findElements(By.xpath("//*[@id=\"forecast-project-grid\"]/div[2]/table/tbody/tr/td[2]"));
				tableRows1.get(0).click();
				Thread.sleep(5000);

				driver.findElement(By.id("promote-project")).click();

				Thread.sleep(2000);

				driver.findElement(By.xpath("//button[text()='OK']")).click();
				Thread.sleep(5000);

				/*
				 * driver.findElement(By.id("active-tab")).click(); Thread.sleep(5000);
				 * 
				 * element.click();
				 * 
				 * Thread.sleep(5000);
				 * 
				 * driver.findElement(By.id("edit-project")).click(); Thread.sleep(10000);
				 * 
				 * driver.findElement(By.xpath("//*[contains(text(),'Cost Table')]")).click();
				 * 
				 * Thread.sleep(5000);
				 * 
				 * //Import
				 * 
				 * driver.findElement(By.id("importButton")).click();
				 * 
				 * Thread.sleep(5000);
				 * 
				 * 
				 * 
				 * driver.findElement(By.xpath("//input[@class='custom-file-input']")).sendKeys(
				 * "J:\\RandD\\Active_Projects\\MY18_07_I0242_Phoenix\\5_SysDevelop\\5_Commiss\\Migration\\KUL\\BU3\\.xlsx"
				 * );
				 * 
				 * driver.findElement(By.xpath("//button[text()='Show Data']")).click();
				 * 
				 * Thread.sleep(70000);
				 * 
				 * driver.findElement(By.id("submit1")).click();
				 * 
				 * 
				 * Thread.sleep(10000); driver.findElement(By.id("submit2")).click();
				 * 
				 * Thread.sleep(10000);
				 */
			} catch (Exception e) {
				System.out.println("Project NOT MOVED TOACTIVE");
				e.printStackTrace();
			}
		} 
	}

}
