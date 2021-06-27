package com.actitime.dataproviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "logindata")
	public static Object[][] loginData()
	{
		Object[][] obj = new String[4][2];
		
		obj[0][0] = "admin";
		obj[0][1] = "manager";
		obj[1][0] = "admin";
		obj[1][1] = "manager";
		obj[2][0] = "admin";
		obj[2][1] = "manager";
		obj[3][0] = "admin";
		obj[3][1] = "manager";
		
		Object[][] obj1 = {{"admin","manager"},{"admin","manager"},{"admin","manager"},{"admin","manager"}};
		
		return obj;
	}
	@DataProvider(name = "logindatafromexcel")
	public static Object[][] loginDataFromExcel() throws IOException
	{	
		File f = new File("./data/testdata.xlsx");		
		FileInputStream fio = new FileInputStream(f);		
		XSSFWorkbook wb = new XSSFWorkbook(fio);		
		XSSFSheet ws = wb.getSheet("logindata");
		
		int rows = ws.getLastRowNum();
		
		Object[][] obj = new String[rows+1][2];
		
		//System.out.println(rows);
		
		for(int x=0;x<=rows;x++)
		{
			String username = ws.getRow(x).getCell(0).getStringCellValue();
			String password = ws.getRow(x).getCell(1).getStringCellValue();
			
			obj[x][0] = username;
			obj[x][1] = password;
			
			
		}		
		wb.close();	
		return obj;
	}

}
