package com.bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	WebDriver Ldriver;

	public LoginPage(WebDriver rdriver) {
		Ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	//a[normalize-space()='Log out']
@FindBy(xpath=("//input[@name='uid']"))@ CacheLookup  WebElement TxtUserName;
@FindBy(xpath=("//input[@name='password']"))@ CacheLookup  WebElement Txtpassword;
@FindBy(xpath=("//input[@name='btnLogin']")) @ CacheLookup  WebElement btnLogin;
@FindBy(xpath=("//a[normalize-space()='Log out']")) @ CacheLookup  WebElement lnkLogout;
	
 public void setUserName(String username) {
	 TxtUserName.sendKeys(username);
 }
	
 public void setPassword(String password) {
	 Txtpassword.sendKeys(password);
 }
	
public void clickSubmit() {
	btnLogin.click();
}	
	


public void clicklnkLogout() {
	lnkLogout.click();
}	
}
