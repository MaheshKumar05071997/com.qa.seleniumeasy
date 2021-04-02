package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;

import com.qa.seleniumeasy.pageObjects.HomePageObjects;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;

public class HomePageEvents {
	
	WebDriver driver;
	public HomePageEvents(WebDriver driver)
	{
		this.driver = driver;
	}
	
	ElementFetch elementFetch = new ElementFetch();

	public void clickOnDemoStart() {
		
		elementFetch.getWebElement(driver, "LINKTEXT", HomePageObjects.btnDemoWebsite).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Demo Start Button");
	}

}
