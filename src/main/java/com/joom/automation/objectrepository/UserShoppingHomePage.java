package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserShoppingHomePage {
	WebDriver driver;

	public UserShoppingHomePage() {
	this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Home")
	private WebElement homebtn;
	
	@FindBy(linkText = "BOOKS")
	private WebElement Booksbtn;
	

	


}
