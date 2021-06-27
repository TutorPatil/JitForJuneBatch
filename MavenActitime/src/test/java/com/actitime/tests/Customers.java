package com.actitime.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.actitime.base.BaseClass;
import com.actitime.utils.CommonUtils;

public class Customers extends BaseClass{
	
	//@Test
	@Test(groups = { "regression", "Customer","customer_001" })
	public static void customer_001() throws Exception
	{

			
			boolean logoutLink = CommonUtils.loginToActiTime();	
			
			Assert.assertTrue(logoutLink, "The Logout Link not displayed!!");
			
			writeResultsToFile("Login_001", "Pass");
						
		
	}

}
