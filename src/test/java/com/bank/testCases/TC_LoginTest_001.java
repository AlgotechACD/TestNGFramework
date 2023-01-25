package com.bank.testCases;

import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bank.pageObject.LoginPage;
import com.bank.Utilities.XLUtils;

public class TC_LoginTest_001 extends baseClass {

	LoginPage loginPage= new LoginPage(driver);
	@Test(priority = 1)
	public  void LoginTest() throws InterruptedException, IOException {

		logger.info("Url is Opened");
		LoginPage loginPage= new LoginPage(driver);
		loginPage.setUserName(username);
		logger.info("enter your username");
		loginPage.setPassword(password);
		logger.info("enter your password");
		loginPage.clickSubmit();
		if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) 
		{
			org.testng.Assert.assertTrue(true);
			logger.info("login test passed");
		}else {
			captureScreen( driver, "LoginTest");
			org.testng.Assert.assertTrue(false);
			logger.info("login test failed");

		}
	}

	

	@Test( dataProvider="logindata")
	public void loginDDT(String user, String pwd) throws IOException {
		LoginPage loginPage= new LoginPage(driver);
		loginPage.setUserName(user);
		logger.info("enter your username");
		loginPage.setPassword(pwd);
		logger.info("enter your password");
		loginPage.clickSubmit();
		if (isAlertPresent()==true) 
		{
		
		driver.switchTo().alert().accept();
		captureScreen( driver,"loginDDT");
		driver.switchTo().defaultContent();
		Assert.assertTrue(false);
		logger.warn("Login failed");
		}else {
			Assert.assertTrue(true);
			logger.info("Login passed");
			loginPage.clicklnkLogout();
			driver.switchTo().alert().accept();
			driver.switchTo().defaultContent();
		}
		
	}
	
	
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException e) {
			return false;
		}
		
	}
	


	@DataProvider(name="logindata")
	String [][]getData() throws IOException
	{

		String path=System.getProperty("user.dir")+"/src/test/java/com/bank/testData/LoginData.xlsx";

		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);

		String logindata[][]=new String[rownum][colcount];

		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path,"Sheet1", i,j);//1 0
			}

		}
		return logindata;
	}	





}
