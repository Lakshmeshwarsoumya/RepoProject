package com.joom.automation.SystemTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.objectrepository.AdminPage;

public class VerifyTodaysOrder extends BaseClassForAdmin {
	@Test
	public void todaysOrders() {
		adp = new AdminPage(driver);
		adp.todaysOrders();
		
		adp.getOrderMgmtLink().click();

		WebElement norDisplayed = driver.findElement(By.xpath("(//b[@class='label orange pull-right'])[1]"));
		WebElement entries = driver.findElement(By.xpath("//div[@class='dataTables_info']"));
		wlib = new WebdriverUtility();
		wlib.waitForElementPresent(driver, norDisplayed);
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(norDisplayed, true);
		sa.assertEquals(entries, true);

	}

}
