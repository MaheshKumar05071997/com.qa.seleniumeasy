package com.qa.seleniumeasy.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.qa.seleniumeasy.pageEvents.HomePageEvents;
import com.qa.seleniumeasy.pageEvents.InputFormEvents;
import com.qa.seleniumeasy.pageEvents.MenuPageEvents;
import com.qa.seleniumeasy.pageEvents.PractiseHomePageEvents;
import com.qa.seleniumeasy.pageEvents.WelcomeBannerEvents;
import com.qa.seleniumeasy.resources.BaseTest;

public class ValidateEnteringValueswithExcel extends BaseTest {

	HomePageEvents homePageEvents;
	WelcomeBannerEvents welcomeBannerEvents;
	PractiseHomePageEvents practiseHomePageEvents;
	MenuPageEvents menuPageEvents;
	InputFormEvents inputFormEvents;

	@Test
	public void validateEnteringValue() throws IOException {
		// getters
		
		
		//driver = super.browserInitialization();

		//driver = browserInitialization();
		homePageEvents = new HomePageEvents(getDriver());
		welcomeBannerEvents = new WelcomeBannerEvents(getDriver());
		practiseHomePageEvents = new PractiseHomePageEvents(getDriver());
		menuPageEvents = new MenuPageEvents(getDriver());
		inputFormEvents = new InputFormEvents(getDriver());

		// tests

		homePageEvents.clickOnDemoStart();
		welcomeBannerEvents.clickOnNoThanks();
		practiseHomePageEvents.clickOnPractiseBtn();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		menuPageEvents.clickOnSimpleDemoForm();
		inputFormEvents.enterMessage();
		inputFormEvents.showMessage();
	}
}
