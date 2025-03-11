package com.joom.automation.package1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.protobuf.TextFormat.ParseException;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.CreateCategoryPage;

public class CreateCategory extends BaseClassForAdmin {

	@Test
	public void createCategory() throws ParseException, IOException, Throwable {
		adp = new AdminPage(driver);
		CreateCategoryPage ccp = new CreateCategoryPage(driver);
		ExcelUtilityForAdmin ela = new ExcelUtilityForAdmin();

		// Fetch category name & description from Excel
		String category = ela.getDataFromExcel("Sheet1", 1, 0);
		String description = ela.getDataFromExcel("Sheet1", 2, 1);

		// Click on "Create Category" link
		adp.getCreateCategoryLink().click();

		// Fill form and create category
		ccp.createCategory(category, description);

		// Wait for confirmation message
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement confirmationMsg = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-success']")));

		// Search for the created category
		WebElement searchTextField = driver.findElement(By.xpath("//input[@aria-controls='DataTables_Table_0']"));
		searchTextField.sendKeys(category);

		// Wait for the category to be displayed in the table
		WebElement createdCategory = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + category + "')]")));

		// Soft Assertion to verify category creation
		SoftAssert sa = new SoftAssert();
		sa.assertTrue(confirmationMsg.isDisplayed(), "Confirmation message not displayed!");
		sa.assertTrue(createdCategory.isDisplayed(), "Category not found in the list!");

		// Assert all
		sa.assertAll();

		System.out.println("Category successfully created and verified.");
	}
}
