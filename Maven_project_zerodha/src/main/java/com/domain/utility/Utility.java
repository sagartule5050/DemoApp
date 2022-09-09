package com.domain.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	//Step 1: make a SHeet as a static
	static Sheet sh;
	
	//step 2: this method is for capturing screenshots when test gets failed
	
	public static void captureScrenshots(WebDriver driver , String testName) throws IOException {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("/Maven_project_zerodha/Screenshots/" + testName +".jpg");
		//FileUtils.copyFile(src, dest);
		FileHandler.copy(src, dest);
		 
	}
	
	//step 3: this method provide data from external excel sheet
	
	public static String getTestData(int rowIndex , int colIndex) throws EncryptedDocumentException, IOException  {
		FileInputStream file = new FileInputStream("./src/test/resources/testData/testdata.xlsx");
		sh=WorkbookFactory.create(file).getSheet("sheet1");
		
	String value = sh.getRow(rowIndex).getCell(colIndex).toString();
		
		return value;
		
	}


}
