package com.joom.automation.IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserShoppingHomePage;

public class UserProductSearchTest extends BaseClassForUser {
	@Test
	public void userProductSearchTest() throws EncryptedDocumentException, IOException, InterruptedException {
		js = new JsonForUserUtility();
		wb = new WebdriverUtility();

		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();

		ushp = new UserShoppingHomePage(driver);
		elib = new ExcelUtilityForAdmin();
		String category = elib.getDataFromExcel("USER", 1, 5);
		Thread.sleep(1000);
		ushp.getSeachtxtfld().sendKeys(category);
		ushp.getLoginbtn().click();
		
		SoftAssert sa= new SoftAssert();
  		sa.assertTrue(driver.getCurrentUrl().contains("Online_Shopping_Application/search-result.php"), "searched product not displayed successfully!");
  		Reporter.log("searched product displayed successfully.",true);
  		sa.assertAll();


	}

}
