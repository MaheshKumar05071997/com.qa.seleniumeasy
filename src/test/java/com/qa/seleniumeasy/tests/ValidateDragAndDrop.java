package com.qa.seleniumeasy.tests;

import org.testng.annotations.Test;

import com.qa.seleniumeasy.pageEvents.DragAndDropEvents;
import com.qa.seleniumeasy.pageEvents.HomePageEvents;
import com.qa.seleniumeasy.pageEvents.MenuPageEvents;
import com.qa.seleniumeasy.pageEvents.PractiseHomePageEvents;
import com.qa.seleniumeasy.pageEvents.ProgressBarEvents;
import com.qa.seleniumeasy.pageEvents.WelcomeBannerEvents;
import com.qa.seleniumeasy.resources.BaseTest;

public class ValidateDragAndDrop extends BaseTest {

	HomePageEvents homePageEvents;
	WelcomeBannerEvents welcomeBannerEvents;
	PractiseHomePageEvents practiseHomePageEvents;
	MenuPageEvents menuPageEvents;
	DragAndDropEvents dragAndDropEvents;
	ProgressBarEvents progressBarEvents;

	@Test
	public void validateDrangAndDrop() throws InterruptedException {

		// getters

		// driver = super.browserInitialization();
		homePageEvents = new HomePageEvents(getDriver());
		welcomeBannerEvents = new WelcomeBannerEvents(getDriver());
		practiseHomePageEvents = new PractiseHomePageEvents(getDriver());
		menuPageEvents = new MenuPageEvents(getDriver());
		dragAndDropEvents = new DragAndDropEvents(getDriver());
		progressBarEvents = new ProgressBarEvents(getDriver());
		// explicitWait = new ExplicitWait(getDriver());

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
		menuPageEvents.clickOnOthers();
		menuPageEvents.clickOnDragAndDrop();
		dragAndDropEvents.dragDropVerifier();
		menuPageEvents.clickOnProgressBar();
		menuPageEvents.selectBootStrapProgressBar();
		progressBarEvents.clickOnDownloadbtn();
		// explicitWait.explictWaitForDownload();

	}

}
