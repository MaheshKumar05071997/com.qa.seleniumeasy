package com.qa.seleniumeasy.pageObjects;

public interface DateObjects {
	
	public String toDate = "//input[@placeholder='Start date']";
	public String endDate = "//input[@placeholder='End date']";
	public String calender = "table-condensed";
	public String current_date = "//td[@class='active selected range-start range-end day']";
	public String nextArrow = "next";
	public String prevArrow = "prev";
	public String month_year = "//th[@class='datepicker-switch']";
	public String date = "//table[@class='table-condensed']/tbody/tr/td";

}
