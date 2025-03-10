package com.joom.automation.baseutility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;

import com.google.protobuf.TextFormat.ParseException;
import com.joom.automation.generic.fileutility.JsonForAdminUtility;

/**
 * CrossBrowserBaseClass manages test setup and teardown across multiple
 * browsers. Supports cross-browser execution using TestNG parameters.
 * 
 * Author: Soumya
 */

public class BaseClassForAdmin {
	WebDriver driver;
	@BeforeSuite
	public void configBS() {
		Reporter.log("=== Connecting to Database and Configuring Reports ===", true);
	}
	@BeforeSuite
	public void congfigBC() throws ParseException, IOException, Throwable {
		Reporter.log("=== Launching Browser: true");
		JsonForAdminUtility jad=new JsonForAdminUtility();
		String browser=jad.readDataFromJson("browser");

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
		
	}
	

}
