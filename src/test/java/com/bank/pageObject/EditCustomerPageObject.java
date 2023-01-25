package com.bank.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPageObject {

	WebDriver Ldriver;
	public EditCustomerPageObject(WebDriver rdriver) {
		Ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	
	
	
	

}
