package com.bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustemerPage {

	WebDriver ldriver;

	public AddCustemerPage(WebDriver rdriver) {
		 ldriver=rdriver;
		 PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[normalize-space()='New Customer']") @CacheLookup 
	private WebElement AddNewCustomer;
	@FindBy(xpath="//input[@name='name']") @CacheLookup 
	private WebElement Customername;
	@FindBy(how=How.NAME, using="rad1") @CacheLookup
	private WebElement RoidGender;
	@FindBy(xpath="//input[@id='dob']") @CacheLookup
	private WebElement txtdob;
	@FindBy(xpath="//textarea[@name='addr']") @CacheLookup
	private WebElement txtaddress;
	@FindBy(xpath="//input[@name='city']") @CacheLookup
	private WebElement txtcity;
	@FindBy(xpath="//input[@name='state']") @CacheLookup
	private WebElement txtstate;
	@FindBy(xpath="//input[@name='pinno']") @CacheLookup
	private WebElement txtpinno;
	@FindBy(xpath="//input[@name='telephoneno']") @CacheLookup
	private WebElement txttelephoneno;
	@FindBy(xpath="//input[@name='emailid']") @CacheLookup
	private WebElement txtemailid;
	@FindBy(xpath="//input[@name='password']") @CacheLookup
	private WebElement txtpassword;
	@FindBy(xpath="//input[@name='sub']") @CacheLookup 
	private WebElement btnSubmit;
	@FindBy(xpath="//input[@name='res']") @CacheLookup 
	private WebElement btnRest;
	
	public void clickAddNewCustomer() {
		AddNewCustomer.click();
	}
	
	public void custName(String Cname) {
		Customername.sendKeys(Cname);	
	}
	
	public void custgender(String cgender) {
		RoidGender.click();
	}
	
	public void cusdob(String mm, String dd, String yy) {
		txtdob.sendKeys(mm);
		txtdob.sendKeys(dd);
		txtdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress) {
		txtaddress.sendKeys(caddress);
	}
	
	public void custcity(String ccity) {
		txtcity.sendKeys(ccity);
	}
	
	public void custstate(String cstate) {
		txtstate.sendKeys(cstate);
	}
	
	
	public void custPinNums(String pinNums ) {
		txtpinno.sendKeys(String.valueOf(pinNums));
	}
	
	public void custPhoneNums(String phoneNums) {
		txttelephoneno.sendKeys(phoneNums);
	}
	
	public void custemail(String cemail) {
		txtemailid.sendKeys(cemail);
	}
	
	public void custpassword(String cpassword) {
		txtpassword.sendKeys(cpassword);
	}
	
	public void custsubmit() {
		btnSubmit.click();
	}
	
	public void custRest() {
		btnRest.click();
	}
	
	
}
