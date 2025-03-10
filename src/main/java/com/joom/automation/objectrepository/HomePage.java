package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(linkText = "Admin Login")
	private WebElement adminLoginLink;

	@FindBy(linkText = "Login")
	private WebElement loginLink;

	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdminLoginLink() {
		return adminLoginLink;
	}

	public WebElement getLoginLink() {
		return loginLink;
	}

}
