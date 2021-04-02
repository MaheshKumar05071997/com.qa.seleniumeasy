package com.qa.seleniumeasy.pageObjects;

public interface InputFormObjects {
	
	public  String txtEnterMessage = "user-message";
	public  String btnShowMessage = "//button[contains(text(), 'Show Message')]";
	public  String userInputvalue = "//div[@id='user-message']/child::label/following-sibling::span";

}
