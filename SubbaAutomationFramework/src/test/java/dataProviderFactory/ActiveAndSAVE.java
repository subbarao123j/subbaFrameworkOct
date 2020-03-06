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

public class ActiveAndSAVE {
	
	
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
		//tab
		
		//driver.findElement(By.xpath("//*[@id=\"active-project-grid\"]/div[3]/ul/li[3]/a")).click();
		
		   	 
	//driver.findElement(By.xpath("//*[@id=\"active-project-grid\"]/div[3]/ul/li[1]/span")).click();
	 
	 
	 List<WebElement> tableRows = driver.findElements(By.xpath("//*[@id=\"active-project-grid\"]/div[2]/table/tbody/tr/td[2]"));
	 Thread.sleep(5000);
	
	 int count=0;
		
	 for(WebElement element :tableRows)
		{

			try {
				
				/*if(count>0)
					driver.findElement(By.xpath("//*[@id=\"active-project-grid\"]/div[3]/ul/li[3]/a")).click();*/
				
				
				//edit project
				
				List<WebElement> tableRows2 = driver
						.findElements(By.xpath("//*[@id=\"active-project-grid\"]/div[2]/table/tbody/tr/td[2]"));
				    tableRows2.get(count).click();
						driver.findElement(By.id("edit-project")).click();
						Thread.sleep(1000);
						
						//cost table
						
						driver.findElement(By.id("cost-table-tab")).click();
						
						Thread.sleep(10000);
						
						
						//Saving in Active
						
						driver.findElement(By.id("saveProjectButton")).click();
						
						Thread.sleep(125000);
						
						//driver.findElement(By.xpath("//button[text()='OK']")).click();
						//Thread.sleep(2000);
						
						driver.findElement(By.xpath("//*[contains(@class,'cui-briefcase')]")).click();
						
						
				//driver.findElement(By.id("active-tab")).click();
			
			
				Thread.sleep(1000);

				count++;
				
				
			
			} catch (Exception e) {
				System.out.println("Project NOT MOVED TOACTIVE");
				e.printStackTrace();
			}
		} 
	}

}
