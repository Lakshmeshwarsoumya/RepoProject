package com.joom.automation.SystemTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;

public class ShoppingCarttTest {
	
	
	@Test
	
	public void addProductToCart() {
		WebdriverUtility wb;
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		wb=new WebdriverUtility();
		wb.waitForPageToLoad(driver);
		
		
	
	
		
	}
	

}
