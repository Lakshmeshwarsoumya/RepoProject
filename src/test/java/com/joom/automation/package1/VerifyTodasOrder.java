package com.joom.automation.package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.objectrepository.AdminPage;

public class VerifyTodasOrder extends BaseClassForAdmin {
	@Test
	public void todaysOrders() {
		adp=new AdminPage(driver);
		adp.todaysOrders();
		
		WebElement norDisplayed = driver.findElement(By.xpath("(//b[@class='label orange pull-right'])[1]"));
		norDisplayed.getText();
	}

}
