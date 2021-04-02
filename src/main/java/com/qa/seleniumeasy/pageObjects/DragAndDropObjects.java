package com.qa.seleniumeasy.pageObjects;

public interface DragAndDropObjects {
	
	public String item_to_dragtxt = "//h3[@class='text-left']";
	public String dragabble_items = "//h3[@class='text-left']/following-sibling::span";
	public String dropHereBox = "mydropzone";
	public String dropped_item_listtxt = "//h3[@class='text-center']";
	public String dropped_item = "droppedlist";

}
