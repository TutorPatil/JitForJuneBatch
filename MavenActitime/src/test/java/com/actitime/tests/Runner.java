package com.actitime.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestNG;

public class Runner {

	public static void main(String[] args) {
	
		TestNG testng = new TestNG();	
      
		List<String> suites = new ArrayList();        
        suites.add("testng.xml");        
        testng.setTestSuites(suites);
        
        testng.run();

	}

}
