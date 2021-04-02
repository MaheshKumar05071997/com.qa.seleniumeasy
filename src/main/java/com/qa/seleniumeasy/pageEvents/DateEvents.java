package com.qa.seleniumeasy.pageEvents;

import java.awt.List;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.seleniumeasy.pageObjects.DateObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;
import com.qa.seleniumeasy.utils.ExcelUtil;

public class DateEvents {

	WebDriver driver;

	public DateEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;
	ExcelUtil excelUtil;

	public void dateVerifier() throws IOException, InterruptedException {

		excelUtil = new ExcelUtil();
		String required_month_year = excelUtil.getCellData("Sheet1", 3, 1);
		String required_date = excelUtil.getCellData("Sheet1", 3, 2);
		elementFetch = new ElementFetch();
		ExtentFactory.getInstance().getExtent().info("This line is after element fetch");
		elementFetch.getWebElement(driver, "XPATH", DateObjects.toDate).click();
		ExtentFactory.getInstance().getExtent().info("Clicked to enter date");
		// elementFetch.getWebElement(driver, "CLASS", DateObjects.calender);
//		boolean month_date = elementFetch.getWebElement(driver, "XPATH", DateObjects.month_year).getText()
//				.contains(required_month_year);
		elementFetch.getListWebElement(driver, "XPATH", DateObjects.date);
		// System.out.println(month_date);
		while (!elementFetch.getWebElement(driver, "XPATH", DateObjects.month_year).getText()
				.contentEquals(required_month_year)) {
			// System.out.println(month_date);
			elementFetch.getWebElement(driver, "CLASS", DateObjects.nextArrow).click();
			// month_date = elementFetch.getWebElement(driver, "XPATH",
			// DateObjects.month_year).getText();
		}
		for (int i = 0; i < elementFetch.getListWebElement(driver, "XPATH", DateObjects.date).size(); i++) {
			String dates = elementFetch.getListWebElement(driver, "XPATH", DateObjects.date).get(i).getText();
			if (dates.equalsIgnoreCase(required_date)) {
				elementFetch.getListWebElement(driver, "XPATH", DateObjects.date).get(i).click();
			}
		}

		Thread.sleep(3000);

		// elementFetch.getWebElement(driver, "XPATH", DateObjects.endDate).click();
	}

}
