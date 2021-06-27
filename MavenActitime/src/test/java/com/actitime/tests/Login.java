package com.actitime.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.TestNG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.collections.Lists;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentXReporter;

public class Login extends BaseClass{
	
	
	public static void main(String[] args) throws Exception {
		
	      
	      
	}	
	
	//@Test(priority = 2) // Order of execution
    //@Test(groups = { "smoke", "Login","login_001" })	
	//@Parameters({ "userName","password" })
	//@Test(dataProvider = "logindatafromexcel",dataProviderClass = com.actitime.DataProviders.class)
	//@Test(groups = { "smoke", "Login","login_001" },priority = 1,dataProvider = "logindatafromexcel",dataProviderClass = com.actitime.DataProviders.class)
	
	
	//@Test(dataProvider = "logindatafromexcel",dataProviderClass = com.actitime.DataProviders.class)
	public static void login_001(String userName, String password) throws Exception
	{		
		boolean logoutLink = CommonUtils.loginToActiTime(userName,password);			
		Assert.assertTrue(logoutLink, "The Logout Link not displayed!!");	
		
		
	}	
	


	//@Test(priority = 1)
	//@Test(dependsOnMethods = { "login_001" })
	//@Test	
    //@Test(groups = { "regression", "Login","login_002" })
	//@Test
	
	@Test
	public static void login_002() throws Exception
	{
		
		boolean errorMsg =	CommonUtils.invalidLoginToActiTime("admin123", "afafaf");		
		
		Assert.assertTrue(errorMsg, "The error msg is not displayed!!");
		
			
	}
	
	//@Test
	public static void fileUploadUsingAUoITEx() throws InterruptedException, IOException, AWTException
	{
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		
		driver.switchTo().frame("iframeResult");
		
		Actions action = new Actions(driver);
		
		action.click(driver.findElement(By.id("myFile"))).build().perform();
		
		Thread.sleep(4000);
		
		
		Runtime.getRuntime().exec("C:\\Users\\sudhapat\\Desktop\\tempauto\\temp\\May_Selenium_Morning\\Selenium_May_Workspace\\MavenActitime\\src\\test\\utilities\\UploadFile.exe");
		
		Thread.sleep(3000);
		
	}
	
	
	//@Test
	public static void directFileUpload() throws InterruptedException, IOException, AWTException
	{
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		
		driver.switchTo().frame("iframeResult");
		
		File f = new File("./src/test/data/testdata.xlsx");
		
		String filePath = f.getAbsolutePath();
		
		driver.findElement(By.id("myFile")).sendKeys(filePath);
		
		//		driver.findElement(By.id("myFile")).sendKeys("D:\\test.txt");
		Thread.sleep(3000);
		
	}
	
	//@Test
	public static void fileUploadUsingRobot() throws InterruptedException, IOException, AWTException
	{
		driver.get("http://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_fileupload_get");
		
		driver.switchTo().frame("iframeResult");
		
		Actions action = new Actions(driver);
		
		action.click(driver.findElement(By.id("myFile"))).build().perform();
		
		Thread.sleep(4000);
		
		
		//Copy the path of the file to the clipboard
		StringSelection stringSelection = new StringSelection("D:\\test.txt");
	    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	    
	    
	    Robot robot = new Robot();
	    
	    robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		Thread.sleep(3000);
		
	}
	
	/**
	 * Extent Report Dependency 
	 * 	<dependency>
			<groupId>com.aventstack</groupId>
			<artifactId>extentreports</artifactId>
			<version>3.1.5</version>
	</dependency>
	 */
	
	//@Test
	public static void extentReportDemo()
	{
		
		File f = new File("./src/test/results/report.html");
		
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(f);		
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		ExtentTest exTest = extent.createTest("SampleTest");
		
		exTest.log(Status.INFO, "Starting the test case Sample");
		exTest.log(Status.INFO, "successfully created the user...");
		
		exTest.log(Status.PASS, "The sample test case Passed");
		
		extent.flush();
		
		
		
		
		
	}
	

	
	
	
	
}
