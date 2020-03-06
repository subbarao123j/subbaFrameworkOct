package dataProviderFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider2 {
	
	
	static XSSFWorkbook wb;
	
	public static XSSFWorkbook excelData(String bu1, String filename) {
	
		try {
			if(bu1.equals("BU1"))
			{
				//BU1 FILE PATH
			wb=new XSSFWorkbook(new FileInputStream(new File("D:\\1 PROJECTS\\7 PHOENIX\\2020\\PSI PROJECTS\\BU1_2020 Project Status KULBKKMCT.xlsx")));
			}else if(bu1.equals("BU3"))
			{//BU3 FILE PATH
				wb=new XSSFWorkbook(new FileInputStream(new File("D:\\1 PROJECTS\\7 PHOENIX\\2020\\PSI PROJECTS\\BU3_Customers.xlsx")));
			}else {
				wb=new XSSFWorkbook(new FileInputStream(new File(filename)));
			}
		}catch (IOException e) {
			
			System.out.println("Unable to read Excel Data "+e.getMessage());
		}
		
		return wb;
		
	}
	
	
	public static String formTheListforAllCellsForString(Cell cell, String rowDataList) {

		if(cell!=null) {
			int cellType = cell.getCellType();
			if (cellType == Cell.CELL_TYPE_STRING) {
				rowDataList = cell.getStringCellValue();
			} else if (cellType == Cell.CELL_TYPE_BOOLEAN) {
				rowDataList = String.valueOf(cell.getBooleanCellValue());
			} else if (cellType == Cell.CELL_TYPE_NUMERIC || cellType == Cell.CELL_TYPE_FORMULA) {
				if (cellType == Cell.CELL_TYPE_NUMERIC && DateUtil.isCellDateFormatted(cell)) {
					SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
					rowDataList = dateFormat.format(cell.getDateCellValue());
				} else if (cellType == Cell.CELL_TYPE_FORMULA) {
					switch (cell.getCachedFormulaResultType()) {
						case Cell.CELL_TYPE_NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								SimpleDateFormat dateFormat = new SimpleDateFormat("MMM-yy");
								rowDataList = dateFormat.format(cell.getDateCellValue());
							} else {
								if (cell.getCellStyle().getDataFormatString().contains("%")) {
									Double value = cell.getNumericCellValue() * 100;
									rowDataList = String.valueOf(value);
								} else {
									Double value = cell.getNumericCellValue();
									rowDataList =String.valueOf(value);
								}
							}
							break;
						case Cell.CELL_TYPE_STRING:
							rowDataList = String.valueOf(cell.getRichStringCellValue());
							break;
						case Cell.CELL_TYPE_ERROR:
							rowDataList= String.valueOf(cell.getErrorCellValue());
							break;
					}
				} else {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					String numberValue = cell.getStringCellValue();
					// String stringCellValue = BigDecimal.valueOf(numberValue).toPlainString();
					rowDataList = numberValue;
				}

			} else if (cellType == Cell.CELL_TYPE_BLANK) {
				rowDataList = String.valueOf(cell.getStringCellValue());
			}
		}
		return rowDataList;

	}
	
	
	

}
