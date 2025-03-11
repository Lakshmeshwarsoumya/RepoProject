package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMyCartPage {
	WebDriver driver;
	public UserMyCartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[text()='PROCCED TO CHEKOUT']")
	private WebElement proceedToCheckoutBtn;
	
	
	public WebElement getProceedToCheckoutBtn() {
		return proceedToCheckoutBtn;
	}
	
	
	
	

}
