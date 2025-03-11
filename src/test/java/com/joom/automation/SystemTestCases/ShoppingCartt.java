package com.joom.automation.SystemTestCases;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;

import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.UserBooksCategoryPage;
import com.joom.automation.objectrepository.UserMyCartPage;
import com.joom.automation.objectrepository.UserPaymentMethodPage;
import com.joom.automation.objectrepository.UserProductDetailsPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;
import com.joom.automation.objectrepository.UserSignUpPage;


public class ShoppingCartt extends BaseClassForUser {
	

	
	
	@Test
	
	public void addProductToCart() throws FileNotFoundException, IOException, ParseException, InterruptedException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		//implicit wait
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		
		//click on home and books button
		UserShoppingHomePage usp=new UserShoppingHomePage(driver);
		//usp.getHomebtn().click();
		
		usp.getBooksbtn().click();
		
		//click on demo book button
		UserBooksCategoryPage ubp= new UserBooksCategoryPage(driver);
		Thread.sleep(2000);
		WebElement ele = ubp.getTheaStiltonlink();
		wb=new WebdriverUtility();
		wb.scrollByAmount(driver,ele);
		ele.click();
		
		
		//click on add to cart button
		UserProductDetailsPage upp=new UserProductDetailsPage(driver);
		upp.getAddtocartbtn().click();
		try {
		//handle alert popup and click on ok
		wb.switchtoAlertAndAccept(driver);
		}catch ( Exception e) {
			System.out.println("popup handled");
		}
		
		Thread.sleep(2000);
		UserMyCartPage umc=new UserMyCartPage(driver);
		WebElement ele1= umc.getProceedToCheckoutBtn();
		wb=new WebdriverUtility();
		wb.scrollToElement(driver, ele1);
		ele1.click();
		
		Thread.sleep(2000);
		UserPaymentMethodPage upm=new UserPaymentMethodPage(driver);
		upm.getCODradiobtn().click();
		upm.getSubmitBtn().click();
		
		
		
		
		
	}
}
		
		
		
		
		
		
		
		
		
		
	
		
		
		
	
		
		
		
	
	
		
	
	


