package com.joom.automation.objectrepository;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubCategoryPage {
	
	@FindBy(xpath="//select[@name='category']")
	private WebElement categoryDropDown;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subCategoryDropDown;
	
	@FindBy(xpath="//input[@name='productName']")
	private WebElement productNameTextField;
	
	@FindBy(xpath="//input[@name='productCompany']")
	private WebElement productCompanyTextField;
	
	@FindBy(xpath="//input[@name='productpricebd']")
	private WebElement productPriceBd;
	
	
	
	
	
	
	
	
	

}
