package com.joom.automation.baseutility;

import java.io.IOException;
import java.sql.SQLException;

import org.openqa.selenium.WebDriver;
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

import com.google.protobuf.TextFormat.ParseException;
import com.joom.automation.WebDriverUtility.WebdriverUtility;
import com.joom.automation.generic.fileutility.ExcelUtilityForAdmin;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;
import com.joom.automation.objectrepository.AdminLoginPage;
import com.joom.automation.objectrepository.AdminPage;
import com.joom.automation.objectrepository.HomePage;
import com.joom.automation.objectrepository.ManageProductsPage;
import com.joom.automation.objectrepository.SubCategoryPage;

/**
 * CrossBrowserBaseClass manages test setup and teardown across multiple
 * browsers. Supports cross-browser execution using TestNG parameters.
 * 
 * Author: Soumya
 */

public class BaseClassForAdmin {
	public WebDriver driver = null;
	public JsonForAdminUtility jad;
	public AdminLoginPage adlp;
	public HomePage hp;
	public AdminPage adp;
	public WebdriverUtility wlib;
	public ExcelUtilityForAdmin ela ;
	public ManageProductsPage mpp;
	public SubCategoryPage scp;

	@BeforeSuite
	public void configBS() {
		Reporter.log("=== Connecting to Database and Configuring Reports ===", true);
	}

	@BeforeClass
	public void configBC() throws Throwable {
		Reporter.log("=== Launching Browser ===", true);
		jad = new JsonForAdminUtility();
		String browser = jad.readDataFromJson("browser");
		String URL = jad.readDataFromJson("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			Reporter.log("Invalid browser specified. Defaulting to Chrome.", true);
			driver = new ChromeDriver();
		}

		driver.manage().window().maximize();
		driver.get(URL); // ✅ Load URL here

	}

	@BeforeMethod
	public void configBM() throws ParseException, IOException, Throwable {
		Reporter.log("=== Logging into Application ===", true);

		jad = new JsonForAdminUtility();

		String USERNAME = jad.readDataFromJson("username");
		String PASSWORD = jad.readDataFromJson("password");

		hp = new HomePage(driver);
		hp.getAdminLoginLink().click();

		adlp = new AdminLoginPage(driver);
		adlp.adminLogin(USERNAME, PASSWORD);

	}

	/**
	 * Logs out of the application after each test method.
	 */
	@AfterMethod
	public void configAM() {
		Reporter.log("=== Logging out of Application ===", true);
		adp = new AdminPage(driver);
		adp.logout();

	}

	@AfterClass
	public void configAC() {
		driver.quit();

	}

	@AfterSuite
	public void configAS() throws SQLException {
		Reporter.log("=== Closing DB Connection and Generating Reports ===", true);

	}

}
