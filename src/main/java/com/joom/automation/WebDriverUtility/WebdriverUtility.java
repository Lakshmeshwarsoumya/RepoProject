package com.joom.automation.WebDriverUtility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

public class WebdriverUtility {
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	}
}
