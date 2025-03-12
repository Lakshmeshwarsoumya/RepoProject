package com.joom.automation.baseutility;


import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForUserUtility;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.UserLoginPage;


public class BaseClassForUser {
	public WebDriver driver=null;
	public JsonForUserUtility js;
	public WebdriverUtility wb;
	public ExcelUtilityForAdmin elib= new ExcelUtilityForAdmin();
	
	
	@BeforeSuite
	public void configBS() {
		Reporter.log("=== Connecting to Database and Configuring Reports ===", true);
	}
	@BeforeClass
	public void congfigBC() throws  IOException, Throwable {
		Reporter.log("=== Launching Browser", true);
		js=new JsonForUserUtility();
		String browser=js.readDataFromJson("browser");
		String URL = js.readDataFromJson("url");
		

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			Reporter.log("Invalid browser specified Defaulting to Chrome.", true);
			//driver = new ChromeDriver();
		}
		driver.get(URL);
		driver.manage().window().maximize();
		
		
	}
		
		@BeforeMethod
		public void configBM() throws IOException, ParseException, InterruptedException {
			Reporter.log("===enter URL",true);
			HomePage hp = new HomePage(driver);
			Thread.sleep(3000);
			hp.getLoginLink().click();

		
		js=new JsonForUserUtility();
		String USERNAME = js.readDataFromJson("username");
		Thread.sleep(3000);
		String PASSWORD = js.readDataFromJson("password");
		Thread.sleep(3000);
		
		UserLoginPage ulp = new UserLoginPage(driver);
		ulp.getEmailtxtfield().sendKeys(USERNAME);
		ulp.getPasswordtxtfield().sendKeys(PASSWORD);
		WebElement ele = ulp.getLoginbtn();
		//wb.scrollToElement(driver, ele);
		wb= new WebdriverUtility();
		wb.scrollByAmountt(driver, ele);
		ele.click();
		
	   
		
	}
		
		
		@AfterMethod
		public void configAM() {
			Reporter.log("===logout===",true);
			//HomePage hp = new HomePage(driver);
		
	
			
			
			
		}
		
		@AfterClass
		public void configAC() {
			Reporter.log("===Close the Browser===",true);
			//driver.quit();
			
		}
		
		@AfterSuite
		public void configAS() {
			Reporter.log("===close DB report backup",true);
		}
	}



