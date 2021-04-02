package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;

import com.qa.seleniumeasy.pageObjects.PractiseHomePageObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;

public class PractiseHomePageEvents {

	public WebDriver driver;

	public PractiseHomePageEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;

	public void clickOnPractiseBtn() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "ID", PractiseHomePageObjects.btnStartPractise).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Start Practise Button");
	}

}
