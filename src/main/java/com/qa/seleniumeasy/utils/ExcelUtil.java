package com.qa.seleniumeasy.utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	public FileInputStream fis;
	public static XSSFWorkbook workBook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;

	DataFormatter formatter;

	public String getCellData(String sheetName, int rowNum, int colNum) throws IOException {
		fis = new FileInputStream(System.getProperty("user.dir") + "/testData/data.xlsx");
		workBook = new XSSFWorkbook(fis);
		sheet = workBook.getSheet(sheetName);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);

		formatter = new DataFormatter();
		String data;
		try {

			data = formatter.formatCellValue(cell);
		} catch (Exception e) {
			data = "";
		}
		workBook.close();
		fis.close();
		return data;
	}

}
