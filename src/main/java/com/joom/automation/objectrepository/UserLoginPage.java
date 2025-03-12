package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserLoginPage {

	WebDriver driver;

	public UserLoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "exampleInputEmail1")
	private WebElement Emailtxtfield;

	@FindBy(name = "password")
	private WebElement Passwordtxtfield;

	@FindBy(name = "login")
	private WebElement loginbtn;

	public WebElement getLoginbtn() {
		return loginbtn;
	}

	public WebElement getEmailtxtfield() {
		return Emailtxtfield;
	}

	public WebElement getPasswordtxtfield() {
		return Passwordtxtfield;
	}
   
	public void LoginAsUser(String email,String password) {
		getEmailtxtfield().sendKeys(email);
		getPasswordtxtfield().sendKeys(password);
		getLoginbtn().click();
	
		
	}
	
}
