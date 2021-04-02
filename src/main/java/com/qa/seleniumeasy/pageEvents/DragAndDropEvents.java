package com.qa.seleniumeasy.pageEvents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.qa.seleniumeasy.pageObjects.DragAndDropObjects;
import com.qa.seleniumeasy.utils.ElementFetch;

public class DragAndDropEvents {

	WebDriver driver;
	Actions actions;

	public DragAndDropEvents(WebDriver driver) {
		this.driver = driver;
	}

	ElementFetch elementFetch;

	public void dragDropVerifier() {
		elementFetch = new ElementFetch();
		actions = new Actions(driver);
		String ItemsToDrag = elementFetch.getWebElement(driver, "XPATH", DragAndDropObjects.item_to_dragtxt).getText();
		Assert.assertEquals(ItemsToDrag, "Items to Drag");

		int totalDraggableNumber = 0;
		List<WebElement> draggableItemNum = elementFetch.getListWebElement(driver, "XPATH",
				DragAndDropObjects.dragabble_items);
		draggableItemNum.size();
		totalDraggableNumber = draggableItemNum.size();

		WebElement dropHere = elementFetch.getWebElement(driver, "ID", DragAndDropObjects.dropHereBox);
		List<WebElement> droppedItems = elementFetch.getListWebElement(driver, "ID", DragAndDropObjects.dropped_item);
		int dropped = 0;
		dropped = droppedItems.size();

		for (WebElement currentDraggableItem : draggableItemNum) {
			actions.dragAndDrop(currentDraggableItem, dropHere).build();
			// actions.release();
			dropped++;
			System.out.println(currentDraggableItem + " dropped");
		}
		if (totalDraggableNumber == dropped - 1) {
			System.out.println(
					"Total item to be dragged were " + totalDraggableNumber + " and total item dragged are " + dropped);
		} else
			Assert.assertTrue(false);

		System.out.println(totalDraggableNumber);
		System.out.println(dropped - 1);
		Assert.assertTrue(false);

	}

}
