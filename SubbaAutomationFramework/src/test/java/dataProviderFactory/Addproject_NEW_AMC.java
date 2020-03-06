package dataProviderFactory;

import java.io.File;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FilenameUtils;
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



public class Addproject_NEW_AMC {
	
	static XSSFWorkbook wb;
	@Test
	//subba code
	public void creatingProject() throws InterruptedException {

		WebDriver driver;

		String targetPath = "D:\\1 PROJECTS\\7 PHOENIX\\2020\\PSI PROJECTS\\Testing";
		// File directory = new File("D:\\1 PROJECTS\\7 PHOENIX\\2020\\PSI
		// PROJECTS\\Testing");

		File directory = new File("J:\\RandD\\Active_Projects\\MY18_07_I0242_Phoenix\\5_SysDevelop\\5_Commiss\\Migration\\KUL\\BU1\\AMCRound2");

		File[] files = directory.listFiles();
		for (File item : files) {
			try {
				String ext = FilenameUtils.getExtension(item.getAbsolutePath());
				if (ext.equals("xls") || ext.equals("xlsx")) {
					System.out.println(item.getAbsolutePath());

					wb = ExcelDataProvider2.excelData("", item.getAbsolutePath());

					System.setProperty("webdriver.chrome.driver",
							"D:\\SOFTWAARES-05082019\\77\\chromedriver_win32\\chromedriver.exe");
					driver = new ChromeDriver();

					driver.manage().window().maximize();

					// driver.manage().timeouts().pageLoadTimeout(1, TimeUnit.SECONDS);

					driver.get("http://10.9.80.189:9001/login");

					System.out.println(driver.getTitle());

					driver.findElement(By.id("username")).sendKeys("kul_subbarao");
					driver.findElement(By.id("password")).sendKeys("Subbarao1516");
					driver.findElement(By.className("btn")).click();

					Thread.sleep(1000);

					driver.findElement(By.xpath("//*[contains(@class,'cui-briefcase')]")).click();

					driver.findElement(By.id("add-project")).click();
					Thread.sleep(1000);

					// Project Status

					WebElement pStatus = driver.findElement(By.xpath("//select[@id='projectStatus']"));

					Select ps = new Select(pStatus);

					ps.selectByVisibleText("Order");

					// Project Type

					WebElement pType = driver.findElement(By.xpath("//select[@id='projectType']"));

					Select pt = new Select(pType);

					pt.selectByVisibleText("AMC");

					// Businessdivision

					WebElement bUnit = driver.findElement(By.id("businessUnit"));

					Select buni = new Select(bUnit);

					buni.selectByVisibleText("BU1");

					// Operative Unit

					WebElement oUnit = driver.findElement(By.id("operativeUnit"));

					Select oUni = new Select(oUnit);

					oUni.selectByVisibleText("Kuala Lumpur");

					// Expected OrderInTake

					SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");

					SimpleDateFormat date = new SimpleDateFormat("dd MMMM YYYY");
					String s = "";

					s = this.getExcelData(10);
					Date d1 = new Date();
					try {
						d1 = date1.parse(s);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					String expOrTake = date.format(d1);

					driver.findElement(By.xpath("//input[@id='expectedOrderIntake']")).sendKeys(expOrTake);

					// Mandatory & Unique Inputs

					// Project Name

					s = this.getExcelData(15);

					driver.findElement(By.xpath("//input[@id='projectName']")).sendKeys(s);

					// Project code

					s = this.getExcelData(14);
					driver.findElement(By.xpath("//input[@id='projectCode']")).sendKeys(s);

					// Sage Code

					s = this.getExcelData(13);
					driver.findElement(By.xpath("//input[@id='sageCode']")).sendKeys(s);

					// Customer

					Thread.sleep(2000);

					s = this.getExcelData(22);

					WebElement cust = driver.findElement(By.id("customer"));

					Select customer = new Select(cust);

					customer.selectByVisibleText(s);

					Thread.sleep(3000);

					// EndCustoemr
					Thread.sleep(2000);

					s = this.getExcelData(21);

					WebElement eCust = driver.findElement(By.id("endCustomer"));

					Select eCustomer = new Select(eCust);
					if (!s.isEmpty() && !s.equalsIgnoreCase(" ") && !s.equalsIgnoreCase("")) {
						eCustomer.selectByVisibleText(s);
					} else {
						s = this.getExcelData(22);
						eCustomer.selectByVisibleText(s);
					}

					Thread.sleep(3000);

					// INCO Terms

					Thread.sleep(2000);

					s = this.getExcelData(29);
					WebElement inCoTerms = driver.findElement(By.id("incoTerms"));

					Select inCoTer = new Select(inCoTerms);

					inCoTer.selectByVisibleText(s);

					// End of warranty

					s = this.getExcelData(16);

					// Contract value

					// Order Start Date

					Thread.sleep(1000);
					Sheet sb = wb.getSheetAt(0);
					String endofWarranty = "";
					for (int amc = 1; amc <= 6; amc++) {
						int b = amc - 1;
						Row r = sb.getRow(amc);
						if (this.checkRowempty(r)) {

							driver.findElement(By.id("save-order")).click();

							s = this.getExcelDataAMCSD(r, 8);

							try {
								d1 = date1.parse(s);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							String expStartDate = date.format(d1);

							driver.findElement(By.id("orderOfStart_" + b)).sendKeys(expStartDate);

							// Order end date
							Thread.sleep(1000);

							s = this.getExcelDataAMCSD(r, 9);

							try {
								d1 = date1.parse(s);
							} catch (ParseException e) {
								e.printStackTrace();
							}
							String expEndDate = date.format(d1);

							driver.findElement(By.id("orderOfEnd_" + b)).sendKeys(expEndDate);
							endofWarranty = expEndDate;
							// Contract value
							s = this.getExcelDataAMCSD(r, 10);
							driver.findElement(By.id("orderValue_" + b)).clear();

							driver.findElement(By.id("orderValue_" + b)).sendKeys(s);

							Thread.sleep(5000);

							driver.findElement(By.id("orderValue_" + b)).click();

						}

					} // Contract currency

					try {
						d1 = date1.parse(endofWarranty);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					Calendar c = Calendar.getInstance();
					c.setTime(d1);
					c.add(Calendar.YEAR, 1); // number of days to add
					String endOfWar = date.format(c.getTime());

					driver.findElement(By.id("endOfWarranty")).sendKeys(endOfWar);

					s = this.getExcelData1(1);

					WebElement cCurren = driver.findElement(By.id("contractualCurrency"));

					Select cCurrency = new Select(cCurren);

					cCurrency.selectByVisibleText(s);

					// Local Currency
					s = this.getExcelData1(1);

					WebElement lCurren = driver.findElement(By.id("localCurrency"));

					Select lCurrency = new Select(lCurren);

					lCurrency.selectByVisibleText(s);

					Thread.sleep(1000);

					// Save

					driver.findElement(By.id("saveProjectButton")).click();
					Thread.sleep(1000);

					String c_url = driver.getCurrentUrl();

					if (c_url.contains("projects")) {

						System.out.println("Project has been saved Succesfully under Project List");

					} else {

						System.out.println("Project Saving is UnSuccesful  under Project List");
					}
					// driver.quit();
				}

			} catch (Exception exception) {
				System.out.print(exception.getMessage());
			}
		}
	}
	
	
	private String getExcelData(int no) {

	   String rowDataList="";
	   if(wb!=null) {
		  Sheet st = wb.getSheetAt(0);
		  int  count = st.getPhysicalNumberOfRows();
	  
			  Cell c = st.getRow(no).getCell(3);
			
			  rowDataList= ExcelDataProvider.formTheListforAllCellsForString(c, rowDataList);
			  
		  }
	   
	   return rowDataList;
	}
	
	
	
	private String getExcelData1(int no) {

		   String rowDataList="";
		   if(wb!=null) {
			  Sheet st = wb.getSheetAt(0);
			  int  count = st.getPhysicalNumberOfRows();
		  
				  Cell c = st.getRow(no).getCell(2);
				
				  rowDataList= ExcelDataProvider.formTheListforAllCellsForString(c, rowDataList);
				  
			  }
		   
		   return rowDataList;
		}
	
	private String getExcelDataAMCSD(Row r,int no) {

		   String rowDataList="";
				  Cell c = r.getCell(no);
				  rowDataList= ExcelDataProvider.formTheListforAllCellsForString(c, rowDataList);
		
		   return rowDataList;
		}
		
	

	// to remove empty rows
		public boolean checkRowempty(Row row) {
			int firstCellNum = 0;
			boolean ind = false;
			if (row != null) {
				int lastCellNum = row.getLastCellNum();

				for (int j = 8; j < 11; j++) {
					Cell cell = row.getCell(j);

					if (cell != null) {
						int cellType = cell.getCellType();
						if (cellType != Cell.CELL_TYPE_BLANK)
							ind = true;
						break;

					}
				}

			}
			return ind;
		}


	
	

}
