package com.bank.testCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.bank.Utilities.ReadConfig;

public class baseClass {
	ReadConfig readConfig= new ReadConfig();

	public String baseURL=readConfig.getApplicationURL();
	public String username=readConfig.getUserName();
	public String password=readConfig.getpassword();
	public static WebDriver driver;

	public static Logger logger;

	@Parameters("browser")
	@BeforeClass
	public void setup(String Browser) {
		logger=Logger.getLogger("ebanking");
		PropertyConfigurator.configure("log4j.properties");
		if (Browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "//Drivers//chromedriver.exe");
			driver= new ChromeDriver();
			driver.get(baseURL);
			driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS) ;
			driver.manage().window().maximize();
		}

	}

	@AfterClass
	public void TearDown() {
	//	driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File source=ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir")+ "/Screenshots/"+tname+ ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");

	}

 public String randomestring() {
	 String generatedstring= RandomStringUtils.randomAlphabetic(8);
	 return generatedstring; 
 }

 public String randomeNum() {
	 String generatedstring2= RandomStringUtils.randomNumeric(4);
	 return generatedstring2; 
 }

}
