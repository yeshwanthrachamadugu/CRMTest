package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.crm.qa.base.Testbase;

public class TestUtil extends Testbase  {
	public static long page_load_Timeout=50;
	public static long implicit_wait=60;
	static String WorkbookPATH="C:\\Users\\Yeshwant\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testData\\FreeCRMTestData.xlsx";
	
	
	
	public void switchtoframe() {
		driver.switchTo().frame("mainpanel");
		}
	
	public static Object[][] gettestData(String sheetName) throws Exception {
		
		FileInputStream fis = new FileInputStream(WorkbookPATH);
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet= book.getSheet(sheetName);
		Object[][] data=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0; i<sheet.getLastRowNum(); i++) {
			for(int j=0; j<sheet.getRow(0).getLastCellNum(); j++) {
				
				data[i][j]=sheet.getRow(i+1).getCell(j).toString();
			}
			
			
		}
		return data;
	}
	public static void takeScreenshotAtEndOfTest() throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));
		
		}
	
	

}
