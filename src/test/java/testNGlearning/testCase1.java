package testNGlearning;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class testCase1 {
	
	@BeforeTest
	public void DBsetUp() {
		System.out.println("----Testing the Setting up the DB----");
	}
	
	@AfterTest
	public void DBClose() {
		System.out.println("----Testing the Closing the DB----");
	}
	
	
	@BeforeMethod
	public void setUp() {
		System.out.println("----Testing the Setting up of the Browser----");
	}
	
	
	@Test (priority = 2)
	public void doLogin() {
		System.out.println("----Testing login functionality---");
	}
	
	@Test (priority = 1)
	public void userReg() {
		System.out.println("----Testing userReg functionality---");
	}
	
	@AfterMethod
	public void tearDown() {
		System.out.println("----Testing the tearDown the Browser----");
	}

}
