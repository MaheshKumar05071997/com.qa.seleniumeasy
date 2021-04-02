package com.qa.seleniumeasy.tests;

import org.testng.annotations.Test;

import com.qa.seleniumeasy.pageEvents.HomePageEvents;
import com.qa.seleniumeasy.pageEvents.MenuPageEvents;
import com.qa.seleniumeasy.pageEvents.TablePaginationEvents;
import com.qa.seleniumeasy.pageEvents.PractiseHomePageEvents;
import com.qa.seleniumeasy.pageEvents.WelcomeBannerEvents;
import com.qa.seleniumeasy.resources.BaseTest;

public class ValidatePaginations extends BaseTest {

	HomePageEvents homePageEvents;
	WelcomeBannerEvents welcomeBannerEvents;
	PractiseHomePageEvents practiseHomePageEvents;
	MenuPageEvents menuPageEvents;
	TablePaginationEvents paginationEvents;

	@Test
	public void validatePaginations() {

		// getters

		// driver = super.browserInitialization();
		homePageEvents = new HomePageEvents(getDriver());
		welcomeBannerEvents = new WelcomeBannerEvents(getDriver());
		practiseHomePageEvents = new PractiseHomePageEvents(getDriver());
		menuPageEvents = new MenuPageEvents(getDriver());
		paginationEvents = new TablePaginationEvents(getDriver());
		
		
		//tests
		
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
		menuPageEvents.clickOnTablePagination();
		paginationEvents.getPaginationStatus();
		
		

	}

}
