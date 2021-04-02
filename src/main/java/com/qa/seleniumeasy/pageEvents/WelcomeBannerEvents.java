package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;
import com.qa.seleniumeasy.pageObjects.WelcomeBannerObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;

public class WelcomeBannerEvents {

	public WebDriver driver;

	public WelcomeBannerEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;

	public void clickOnNoThanks() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", WelcomeBannerObjects.linkNoThanks).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on No Thanks button");
	}

}
