package com.bank.testCases;

import java.io.IOException;

import org.testng.annotations.Test;

import com.bank.pageObject.AddCustemerPage;
import com.bank.pageObject.LoginPage;

public class TC_AddCustomerTest_002 extends baseClass {

	
	
	
	@Test
	public void addNewCustomer() throws InterruptedException, IOException {
		logger.info("Url is Opened");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("enter your username");
		loginPage.setPassword(password);
		logger.info("enter your password");
		loginPage.clickSubmit();
		
		AddCustemerPage addcustemerPage = new AddCustemerPage(driver);
		addcustemerPage.clickAddNewCustomer();
		
		Thread.sleep(3000);
		logger.info("providing customer details....");
		
		addcustemerPage.custName("Chouaib");
		addcustemerPage.custgender("male");
		addcustemerPage.cusdob("08","08", "1988");
		 Thread.sleep(3000);
		 addcustemerPage.custAddress("INDIA");
		 addcustemerPage.custcity("HYD");
		 addcustemerPage.custstate("AP");
		 addcustemerPage.custPinNums("888888");
		 String phone ="888888"+randomeNum();		 
		 addcustemerPage.custPhoneNums(phone);
		 String email=randomestring()+"@gmail.com";
		 addcustemerPage.custemail(email);
		 String pwd=randomestring();
		 addcustemerPage.custpassword(pwd);
		 addcustemerPage.custsubmit();
		
		 Thread.sleep(3000);
		 logger.info("validation started....");
		 
		 boolean res= driver.getPageSource().contains("Customer Registered Successfully");
		 if (res=true) {
			 org.testng.Assert.assertTrue(true);
			 logger.info("test case passed....");
		}else {
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			org.testng.Assert.assertTrue(false);
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
