package com.joom.automation.IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.SubCategoryPage;

public class CreateSubCategoryTest extends BaseClassForAdmin {
	@Test(groups="Integration")
	public void insertSubcategory() throws InterruptedException, EncryptedDocumentException, IOException {
		wlib = new WebdriverUtility();
		ela = new ExcelUtilityForAdmin();
		scp = new SubCategoryPage(driver);
		adp = new AdminPage(driver);
		WebElement subCategory = adp.getSubCategoryLink();
		subCategory.click();
		
		wlib.waitForElementPresent(driver,subCategory , 20);
		WebElement category = scp.getCategoryDropdown();
		category.click();
		String categoryList = ela.getDataFromExcel("Sheet1", 1, 0);

		WebElement selectDropdown = scp.getCategoryDropdown();
		wlib.select(selectDropdown, categoryList);
		String subCategoryList = ela.getDataFromExcel("Sheet1", 1, 2);
		wlib.waitForElementPresent(driver,category , 20);
		scp.getSubCategoryDropdown().sendKeys(subCategoryList);
		
		WebElement createButton = scp.getCreateButton();
		wlib.waitForElementPresent(driver,createButton , 20);
		createButton.click();
		WebElement text = scp.getConfirmMsg();
		wlib.waitForElementPresent(driver,text , 20);
		
		text.getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(text, true);
		Reporter.log("created sub category", true);

	}

}
