package com.joom.automation.package1;


import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.HomePage;

public class ShoppingCart {
	@Test
	public void addProductToCart() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/");
		HomePage hp = new HomePage(driver);
		hp.getAdminLoginLink().click();
		
		AdminLoginPage adp=new AdminLoginPage(driver);
		adp.adminLogin("admin", "admin");
		
		
		
		
	}
	

}
