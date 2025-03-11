package com.joom.automation.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProductDetailsPage {
	WebDriver driver;
public UserProductDetailsPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver,this);
}

@FindBy(xpath = "(//a[@class='btn btn-primary'])[1]")
private WebElement addtocartbtn;

public WebElement getAddtocartbtn() {
	return addtocartbtn;
}


	

}
