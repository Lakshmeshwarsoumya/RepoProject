package com.joom.automation.IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserShoppingHomePage;

public class UserProductSearchTest extends BaseClassForUser{
	@Test
	public void userProductSearchTest(WebDriver driver) throws EncryptedDocumentException, IOException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		ushp= new UserShoppingHomePage(driver);
		
		//elib.getDataFromExcel("USER2", 0, 0);
		
		ushp.getSeachtxtfld().sendKeys("Books");
		ushp.getSeachtxtfld().click();
		
		
		
		
		
		
	}
	

}
