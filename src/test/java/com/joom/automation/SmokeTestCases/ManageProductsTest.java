package com.joom.automation.SmokeTestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.objectrepository.ManageProductsPage;
@Listeners(com.joom.automation.listenerutility.ListenerImplementation.class)
public class ManageProductsTest extends BaseClassForAdmin {
	@Test(groups="Smoke")
	public void deleteProducts() throws EncryptedDocumentException, IOException {
		mpp = new ManageProductsPage(driver);
		ela = new ExcelUtilityForAdmin();
		wlib=new WebdriverUtility();
		WebElement productLink = mpp.getManageProductsLink();
		wlib.waitForElementPresent(driver,productLink , 20);
		productLink.click();
		//String productName = ela.getDataFromExcel("Sheet1", 1, 9);
		wlib.waitForPageToLoad(driver);
		driver.findElement(By.xpath("//td[text()='Lenovo Ideapad 110 APU Quad Core A6 6th Gen']/following-sibling::td[last()]//i[contains(@class,'icon-remove-sign')]")).click();
		wlib.switchToAlertAndAccept(driver);
		
	}

}
