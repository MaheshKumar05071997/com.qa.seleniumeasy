package com.qa.seleniumeasy.tests;

import org.testng.annotations.Test;

import com.qa.seleniumeasy.pageEvents.HomePageEvents;
import com.qa.seleniumeasy.pageEvents.MenuPageEvents;
import com.qa.seleniumeasy.pageEvents.PractiseHomePageEvents;
import com.qa.seleniumeasy.pageEvents.TableDataSearchEvents;
import com.qa.seleniumeasy.pageEvents.WelcomeBannerEvents;
import com.qa.seleniumeasy.resources.BaseTest;

public class ValidateDataFetch extends BaseTest {

	HomePageEvents homePageEvents;
	WelcomeBannerEvents welcomeBannerEvents;
	PractiseHomePageEvents practiseHomePageEvents;
	MenuPageEvents menuPageEvents;
	TableDataSearchEvents tableDataSearchEvents;

	@Test
	public void validateDataFetch() {
		// getters

		// driver = super.browserInitialization();
		homePageEvents = new HomePageEvents(getDriver());
		welcomeBannerEvents = new WelcomeBannerEvents(getDriver());
		practiseHomePageEvents = new PractiseHomePageEvents(getDriver());
		menuPageEvents = new MenuPageEvents(getDriver());
		tableDataSearchEvents = new TableDataSearchEvents(getDriver());

		// tests

		// test scenarios
		homePageEvents.clickOnDemoStart();
		welcomeBannerEvents.clickOnNoThanks();
		practiseHomePageEvents.clickOnPractiseBtn();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuPageEvents.clickOnTableLink();
		menuPageEvents.clickOnTableDataSearch();
		tableDataSearchEvents.retriveHeadItem();
		tableDataSearchEvents.retriveBodyItem();
	}
	

}
