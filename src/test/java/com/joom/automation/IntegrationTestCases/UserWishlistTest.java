package com.joom.automation.IntegrationTestCases;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.baseutility.BaseClassForUser;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.UserBooksCategoryPage;
import com.joom.automation.objectrepository.UserLogOutPage;
import com.joom.automation.objectrepository.UserProductDetailsPage;
import com.joom.automation.objectrepository.UserShoppingHomePage;

public class UserWishlistTest extends BaseClassForUser {
@Test
public void userWishlistTest() throws InterruptedException {
	
	
	js=new JsonForUserUtility();
	wb=new WebdriverUtility();
	
	wb.waitForPageToLoad(driver);
	driver.manage().window().maximize();
	
	//click on books link
	UserShoppingHomePage ushp = new UserShoppingHomePage(driver);
	ushp.getBooksbtn().click();
	
	// scroll down and click on theastilton book
	UserBooksCategoryPage ubcp= new UserBooksCategoryPage(driver);
	WebElement book = ubcp.getDemobooklink();
	wb.scrollToElements(driver, book);
	ubcp.getDemobooklink().click();
	Thread.sleep(2000);
	
	//to click on wishlist button
	UserProductDetailsPage updp= new UserProductDetailsPage(driver);
	updp.getWishlistBtn().click();
	
	Thread.sleep(2000);
	UserLogOutPage ulp = new UserLogOutPage(driver);
	ulp.getLogoutlink().click();

	
}
	


}
