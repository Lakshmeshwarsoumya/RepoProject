package com.joom.automation.package1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.google.protobuf.TextFormat.ParseException;
import com.joom.automation.baseutility.BaseClassForAdmin;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;
import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.HomePage;

public class CreateCategory extends BaseClassForAdmin {
	@Test
	public void createCategory() throws ParseException, IOException, Throwable {
		adp=new AdminPage(driver);
		adp.getCreateCategoryLink().click();
		
		
		
		

		

	}

}
