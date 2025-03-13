package com.joom.automation.SystemTestCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ShoppingCartTest {

	@Test
	public void addProductToCart() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://49.249.28.218:8081/AppServer/Online_Shopping_Application/index.php");
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.scrollByAmount(0, 2000);
		driver.findElement(By.xpath("(//input[@type='email'])[1]")).sendKeys("anuj.lpu1@gmail.com");
		driver.findElement(By.xpath("(//input[@type='password'])[1]")).sendKeys("Test@123");
		Thread.sleep(2000);
		WebElement ele =driver.findElement(By.xpath("//button[text()='Login']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,2000)");
		ele.click();

		driver.findElement(By.xpath("//a[text()=' Books']")).click();
		driver.findElement(By.xpath("(//a[@href='category.php?cid=7'])[1]")).click();
		Thread.sleep(2000);
		 act = new Actions(driver);
		act.scrollByAmount(0, 500).perform();
		driver.findElement(By.xpath("(//button[contains(text(),'Add to cart')])[1]")).click();
		driver.switchTo().alert().accept();
		Thread.sleep(5000);
		driver.findElement(By.xpath("(//a[text()='My Cart'])[1]")).click();
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		Thread.sleep(5000);
		act.scrollByAmount(0, 500).perform();
		act.moveToElement(driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']"))).perform();
		driver.findElement(By.xpath("//button[text()='PROCCED TO CHEKOUT']")).click();
		Thread.sleep(7000);
		// driver.findElement(By.xpath("//input[@checked='checked']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@type='submit']")).click();

	}
}
