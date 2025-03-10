package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLoginPage {
	@FindBy(id = "inputEmail")
	private WebElement adminTextField;

	@FindBy(id = "inputPassword")
	private WebElement adminPasswordTextField;

	@FindBy(xpath = "//button[text()='Login']")
	private WebElement loginButton;

	public AdminLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	public WebElement getAdminTextField() {
		return adminTextField;
	}

	public WebElement getAdminPasswordTextField() {
		return adminPasswordTextField;
	}

	public WebElement getLoginButton() {
		return loginButton;
	}

}
