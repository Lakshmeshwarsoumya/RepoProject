package com.joom.automation.IntegrationTestCases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserShoppingHomePage;

public class UserProductSearchTest extends BaseClassForUser{
	@Test
	public void userProductSearchTest(WebDriver driver) {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		UserShoppingHomePage ushp= new UserShoppingHomePage(driver);
		ushp.getSeachtxtfld().sendKeys("Books");
		ushp.getSeachtxtfld().click();
		
		
		
		
		
		
	}
	

}
