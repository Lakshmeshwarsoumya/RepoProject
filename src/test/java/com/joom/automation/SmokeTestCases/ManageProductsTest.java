package com.joom.automation.SmokeTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.objectrepository.ManageProductsPage;

public class ManageProductsTest extends BaseClassForAdmin {
	@Test
	public void deleteProducts() throws EncryptedDocumentException, IOException {
		mpp = new ManageProductsPage(driver);
		ela = new ExcelUtilityForAdmin();
		wlib=new WebdriverUtility();
		mpp.getManageProductsLink().click();
		driver.findElement(By.xpath("//td[text()='Micromax Canvas Laptab II (WIFI) Atom 4th Gen']/following-sibling::td[last()]//i[contains(@class,'icon-remove-sign')]"));
		//wlib.switchToAlertAndAccept(driver);
		
	}

}
