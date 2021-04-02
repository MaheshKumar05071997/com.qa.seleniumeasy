package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;

import com.qa.seleniumeasy.pageObjects.ProgressBarObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;

public class ProgressBarEvents {

	ElementFetch elementFetch;
	WebDriver driver;

	public ProgressBarEvents(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnDownloadbtn() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "ID", ProgressBarObjects.btnDownload).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Download button");
	}
}
