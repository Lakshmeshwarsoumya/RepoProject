package com.joom.automation.SmoketestCases;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserHomePage;
import com.joom.automation.objectrepository.UserShoppingHomePage;
import com.joom.automation.objectrepository.UserSignUpPage;

public class UserNewContactTest extends BaseClassForUser{
	@Test
	
	public void userNewContactTest() throws EncryptedDocumentException, IOException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		elib=new ExcelUtilityForAdmin() ;

		
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		 ushp= new UserShoppingHomePage(driver);
		ushp.getLoginlink().click();
		
		 uhp= new UserHomePage(driver);
	
		String Fullname = elib.gatDataFromExcel("USER", 1, 1);
		 uhp.getFullnametxtfield().sendKeys(Fullname);
		 
		String Email = elib.gatDataFromExcel("USER", 1, 2);
		uhp.getEmailtxtfld().sendKeys(Email);
		//scroll here
	    usp= new UserSignUpPage(driver);
		WebElement signup = usp.getSignUpbtn();
		wb.scrollToElements(driver,signup);
		usp.getSignUpbtn().click();
		
		
		
		String Contactno = elib.gatDataFromExcel("USER", 1, 3);
		uhp.getContactnotxtfld().sendKeys(Contactno);
		
		String password= elib.gatDataFromExcel("USER", 1, 4);
		uhp.getPasswordtxtfld().sendKeys(password);
		
		String confirmpassword = elib.gatDataFromExcel("USER", 1, 5);
		uhp.getConfirmpasswordtxtfld().sendKeys(confirmpassword);
		
		
		
		
	}
}
