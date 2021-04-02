package com.qa.seleniumeasy.pageEvents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.seleniumeasy.pageObjects.InputFormObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;
import com.qa.seleniumeasy.utils.ExcelUtil;

public class InputFormEvents {

	public WebDriver driver;

	public InputFormEvents(WebDriver driver) {
		this.driver = driver;
	}

	ExcelUtil excelUtil;
	ElementFetch elementFetch;

	String message;

	public void enterMessage() throws IOException {

		excelUtil = new ExcelUtil();
		message = excelUtil.getCellData("Sheet1", 3, 0);

		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "ID", InputFormObjects.txtEnterMessage).sendKeys(message);
		ExtentFactory.getInstance().getExtent().info("Entered data from Excel Sheet");
	}

	public void showMessage() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "XPATH", InputFormObjects.btnShowMessage).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Show message button");
		String expectedValue = elementFetch.getWebElement(driver, "XPATH", InputFormObjects.userInputvalue).getText();
		Assert.assertTrue(false);
	}

}
