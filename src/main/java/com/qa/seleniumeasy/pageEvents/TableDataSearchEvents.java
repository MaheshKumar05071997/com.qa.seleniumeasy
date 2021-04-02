package com.qa.seleniumeasy.pageEvents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.seleniumeasy.pageObjects.TableDataSearchObjects;
import com.qa.seleniumeasy.utils.ElementFetch;

public class TableDataSearchEvents {

	public WebDriver driver;

	public TableDataSearchEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;

	public void retriveHeadItem() {
		elementFetch = new ElementFetch();
		List<WebElement> tableHeadSize = elementFetch.getListWebElement(driver, "XPATH",
				TableDataSearchObjects.table_head);
		tableHeadSize.size();
		for (WebElement headValue : tableHeadSize) {
			// String values = elementFetch.getWebElement(driver, "XPATH",
			// TableDataSearchObjects.table_head).getText();
			System.out.println(headValue.getText());
		}
	}
	
	public void retriveBodyItem()
	{
		elementFetch = new ElementFetch();
		List<WebElement> tableBodySize =  elementFetch.getListWebElement(driver, "XPATH", TableDataSearchObjects.table_body);
		tableBodySize.size();
		for(WebElement bodyValue: tableBodySize)
		{
			System.out.println(bodyValue.getText());
		}
	}
}
