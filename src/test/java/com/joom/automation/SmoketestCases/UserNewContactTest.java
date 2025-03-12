package com.joom.automation.SmoketestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserHomePage;

public class UserNewContactTest extends BaseClassForUser{
	@Test
	
	public void userNewContactTest(WebDriver driver) throws EncryptedDocumentException, IOException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
	

		
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		UserHomePage uhp= new UserHomePage(driver);
		String Fullname = elib.gatDataFromExcel("USER", 1, 1);
		String Email = elib.gatDataFromExcel("USER", 1, 2);
		//scroll here
		
		
		String Contactno = elib.gatDataFromExcel("USER", 1, 3);
		String password= elib.gatDataFromExcel("USER", 1, 4);
		String confirmpassword = elib.gatDataFromExcel("USER", 1, 5);
		
	}
}
