package com.actitime.utils;

import java.io.IOException;

import org.openqa.selenium.By;

import com.actitime.base.BaseClass;

public class CommonUtils extends BaseClass{
	
	public static boolean loginToActiTime() throws IOException
	{
		boolean logoutLink = false;
		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","UserName_EidtBox"))).sendKeys(testdataMap.get("Login$UserName_EidtBox"));
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Password_EditBox"))).sendKeys(testdataMap.get("Login$Password_EditBox"));		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Ok_Button"))).click();
		
		try
		{
			logoutLink = driver.findElement(By.xpath(getLocatorDataFromMap("Home","Logout_Link"))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			writeLogs("The logout link not displayed");
		}
		
		return logoutLink;
		
	}
	
	
	public static boolean loginToActiTime(String userName, String password) throws IOException
	{
		boolean logoutLink = false;
		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","UserName_EidtBox"))).sendKeys(userName);
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Password_EditBox"))).sendKeys(password);		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Ok_Button"))).click();
		
		try
		{
			logoutLink = driver.findElement(By.xpath(getLocatorDataFromMap("Home","Logout_Link"))).isDisplayed();
		}
		catch(Exception e)
		{
			e.printStackTrace();
			writeLogs("The logout link not displayed");
		}
		
		return logoutLink;
		
	}
	
	
	public static boolean invalidLoginToActiTime(String invalidUser, String  invalidPassword) throws Exception
	{
		boolean errorMsg = true;
		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","UserName_EidtBox"))).sendKeys(invalidUser);
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Password_EditBox"))).sendKeys(invalidPassword);		
		driver.findElement(By.xpath(getLocatorDataFromMap("Login","Ok_Button"))).click();
		
		Thread.sleep(3000);
		
		try
		{
			errorMsg = driver.findElement(By.xpath(getLocatorDataFromMap("Login","ErrorMsg_Text"))).isDisplayed();
		}
		catch(Exception e)
		{
			errorMsg = false;
			e.printStackTrace();
			writeLogs("The error message is not displayed");
		}
		
		return errorMsg;
		
	}
	
	public static void selectModule(String moduleName) throws Exception
	{
		String module = getLocatorData("Home","ModuleName_Text");
		String moduleNameXpath = module.replace("--TEXTREPLACE--", moduleName);		
		driver.findElement(By.xpath(moduleNameXpath)).click();
		
		
	}


}
