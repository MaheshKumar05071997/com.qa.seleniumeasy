package com.qa.seleniumeasy.pageEvents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.qa.seleniumeasy.pageObjects.MenuPageObjects;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.utils.ElementFetch;

public class MenuPageEvents {

	public WebDriver driver;

	public MenuPageEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;
	Select select;

	public void clickOnSimpleDemoForm() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.simple_form_demo).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Simple Demo Form");
	}

	public void clickOnTableLink() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.table).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Table Link");
	}

	public void clickOnTablePagination() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.table_pagination).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Table Pagination Link");
	}

	public void clickOnTableDataSearch() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.table_data_search).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Clicked on Table Search Data");
	}

	public void clickOnOthers() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.others).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Others Link");
	}

	public void clickOnDragAndDrop() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.drag_and_drop).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Drag And Dop Link");
	}

	public void clickOnProgressBar() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.progress_bars).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Progress Bars");
	}

	public void selectBootStrapProgressBar() throws InterruptedException {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "XPATH", MenuPageObjects.bootstrap_progress_bar).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on BootStrap Progress Bar");

//		select = new Select(bootstrap_progress_bar);
//		select.selectByVisibleText("Bootstrap Progress bar");
//		Thread.sleep(4000);
	}

	public void clickOnDatePickers() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.date_pickers).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on Date Pickers");
	}

	public void selectBootstrapDatePicker() {
		elementFetch = new ElementFetch();
		elementFetch.getWebElement(driver, "LINKTEXT", MenuPageObjects.bootstrap_date_picker).click();
		ExtentFactory.getInstance().getExtent().info("Clicked on BootStrap Date picker");
	}

}
