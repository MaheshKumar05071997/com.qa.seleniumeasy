package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;

import com.qa.seleniumeasy.pageObjects.TablePaginationObjects;
import com.qa.seleniumeasy.utils.ElementFetch;

public class TablePaginationEvents {

	public WebDriver driver;

	public TablePaginationEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;

	public void getPaginationStatus() {
		elementFetch = new ElementFetch();
		// String currentPageNumber = elementFetch.getWebElement(driver, "XPATH",
		// PaginationObjects.activeButton)
		// .getText();
		boolean nextStatus = elementFetch.getWebElement(driver, "CLASS", TablePaginationObjects.nextLink).isDisplayed();
		boolean prevStatus = elementFetch.getWebElement(driver, "CLASS", TablePaginationObjects.prevLink).isDisplayed();

		// logic

//		if (!prevStatus) {
//			System.out.println("You are on the first page");
//		} else 
		if (nextStatus) {
			while (nextStatus) {
				elementFetch.getWebElement(driver, "CLASS", TablePaginationObjects.nextLink).click();
				//nextStatus = false;

				String currentPageNumber = elementFetch.getWebElement(driver, "XPATH", TablePaginationObjects.activeButton)
						.getText();
				System.out.println("You are on the " + currentPageNumber + " page");
				nextStatus = elementFetch.getWebElement(driver, "CLASS", TablePaginationObjects.nextLink).isDisplayed();
			}
		}
		System.out.println("Done!");
	}

}
