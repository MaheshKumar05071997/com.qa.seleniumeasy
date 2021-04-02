package com.qa.seleniumeasy.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.seleniumeasy.pageEvents.DateEvents;
import com.qa.seleniumeasy.pageEvents.HomePageEvents;
import com.qa.seleniumeasy.pageEvents.MenuPageEvents;
import com.qa.seleniumeasy.pageEvents.PractiseHomePageEvents;
import com.qa.seleniumeasy.pageEvents.WelcomeBannerEvents;
import com.qa.seleniumeasy.resources.BaseTest;

public class ValidateDate extends BaseTest {

	HomePageEvents homePageEvents;
	WelcomeBannerEvents welcomeBannerEvents;
	PractiseHomePageEvents practiseHomePageEvents;
	MenuPageEvents menuPageEvents;
	DateEvents dateEvents;

	@Test
	public void validateDate() throws IOException, InterruptedException {
		// driver = super.browserInitialization();
		homePageEvents = new HomePageEvents(getDriver());
		welcomeBannerEvents = new WelcomeBannerEvents(getDriver());
		practiseHomePageEvents = new PractiseHomePageEvents(getDriver());
		menuPageEvents = new MenuPageEvents(getDriver());
		dateEvents = new DateEvents(getDriver());

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
		menuPageEvents.clickOnDatePickers();
		menuPageEvents.selectBootstrapDatePicker();
		dateEvents.dateVerifier();

	}
}
