package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider() {
	
		try {
			wb=new XSSFWorkbook(new FileInputStream(new File(System.getProperty("user.dir")+"/TestData/TestData.xlsx")));
		}catch (IOException e) {
			
			System.out.println("Unable to read Excel Data "+e.getMessage());
		}
		
	}
	
	
	public String getCellData(String sheetName,int row, int col)
	{
		XSSFCell cell=wb.getSheet(sheetName).getRow(row).getCell(col);
		
		String data=null;
		
		if(cell.getCellTypeEnum()==CellType.STRING)
		{
			data=cell.getStringCellValue();
		}
		else if(cell.getCellTypeEnum()==CellType.NUMERIC)
		{
			data= String.valueOf((int)cell.getNumericCellValue());
		}
		else if(cell.getCellTypeEnum()==CellType.BLANK)
		{
			data="";
		}
		return data;
	}
	
	
	

}
