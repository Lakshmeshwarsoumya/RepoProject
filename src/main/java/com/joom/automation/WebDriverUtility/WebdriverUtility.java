package com.joom.automation.WebDriverUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtility {

	public void waitForPageToLoad(WebDriver driver) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));

	}
	// Wait until an element is visible

	public void waitForElementPresent(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(element));

	}
	
	public void switchtoAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	
	public void scrollByAmount(WebDriver driver,WebElement element) {
		Actions act = new Actions(driver);
		act.scrollByAmount(0,500).perform();
		
	}
	
	public void scrollToElement(WebDriver driver,WebElement ele) {
		Actions a = new Actions(driver);
		a.scrollToElement(ele).perform();
	}

}
 