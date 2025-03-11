package com.joom.automation.IntegrationTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.InsertProductPage;

public class InsertProduct extends BaseClassForAdmin {
	@Test
	public void insertProduct() throws EncryptedDocumentException, IOException, InterruptedException {
		adp = new AdminPage(driver);
		ela = new ExcelUtilityForAdmin();
		String category = ela.getDataFromExcel("Sheet1", 1, 0);
		adp.getInserProductLink().click();

		InsertProductPage ipp = new InsertProductPage(driver);
		wlib = new WebdriverUtility();
		wlib.select(ipp.getCategoryDropDown(), category);
		Thread.sleep(2000);
		String subcategory = ela.getDataFromExcel("Sheet1", 1, 2);

		wlib.select(ipp.getSubCategoryDropDown(), subcategory);
		String productName = ela.getDataFromExcel("Sheet1", 1, 3);

		ipp.getProductNameTextField().sendKeys(productName);

		String productCompany = ela.getDataFromExcel("Sheet1", 1, 4);

		ipp.getProductCompanyTextField().sendKeys(productCompany);

		String productPriceBeforeDiscount = ela.getDataFromExcel("Sheet1", 1, 5);

		ipp.getProductPriceBd().sendKeys(productPriceBeforeDiscount);

		String productPriceAfterDiscount = ela.getDataFromExcel("Sheet1", 1, 6);
		ipp.getProductpriceAd().sendKeys(productPriceAfterDiscount);

		String productDiscription = ela.getDataFromExcel("Sheet1", 1, 1);

		ipp.getDescriptionTextField().sendKeys(productDiscription);
		

	}

}
