package com.joom.automation.SystemTestCases;

import java.time.Duration;


import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserFashionCategoryPage;
import com.joom.automation.objectrepository.UserMyCartPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;

public class UpdatingShoppingCart extends  BaseClassForUser{
	
	@Test
	public void updatingShoppingCart() throws InterruptedException {
		js=new JsonForUserUtility();
		wb=new WebdriverUtility();
		//implicit wait
		wb.waitForPageToLoad(driver);
		driver.manage().window().maximize();
		
		//click on fashion
		UserShoppingHomePage ushp= new UserShoppingHomePage(driver);
		ushp.getFashionbtn().click();
		
		//click on saree product
		UserFashionCategoryPage ufcp=new UserFashionCategoryPage(driver);
		Thread.sleep(2000);
		//it is not scrolling
		WebElement shoe= ufcp.getShoebtn();
		wb=new WebdriverUtility();
		//wb.scrollToElement(driver, saree);
		//saree.click();
		Thread.sleep(2000);
		//wb.scrollByAmountt(driver, saree);
		wb.scrollToElements(driver,shoe);
		shoe.click();
		Thread.sleep(2000);
		//product has been added to the cart popup
		//wb.switchtoAlertAndAccept(driver);
		wb.scrollToElements(driver, shoe);
		ufcp.getAddtoCartBtn().click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
		    wait.until(ExpectedConditions.alertIsPresent()); 
		    Alert alert = driver.switchTo().alert();
		    alert.accept();
		} catch (Exception e) {
		    System.out.println("No alert appeared.");
		}
		Thread.sleep(2000);
		
	
		//click on updateshopping cart button
		UserMyCartPage umcp=new UserMyCartPage(driver);
		Thread.sleep(2000);
		WebElement update = umcp.getUpdateShoppingCartBtn();
		wb= new WebdriverUtility();
		wb.scrollByAmount(driver, update);
		umcp.getUpdateShoppingCartBtn().click();
		Thread.sleep(2000);
		//your cart has been updated popup
		wb.switchtoAlertAndAccept(driver);
		
		
		
		
		
		
		
	}

}
