package com.qa.seleniumeasy.resources;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.bouncycastle.jcajce.provider.symmetric.ARC4.Base;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qa.seleniumeasy.configFiles.constantValues;

import bsh.Capabilities;

public class ExtentReportNG extends BaseTest {
	
	
	public static ExtentReports extentReports1;
//	Capabilities caps = (Capabilities) ((RemoteWebDriver)currentBrowser).getCapabilities();
//	String browserName = caps.
	
	
	public static ExtentReports setupExtentReports() {
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);

		String reportPath = System.getProperty("user.dir") + File.separator + "reports" + File.separator
				+ "automationreport_" + actualDate + ".html";
		
		ExtentHtmlReporter sprarkReporter = new ExtentHtmlReporter(reportPath);
		extentReports1 = new ExtentReports();
		extentReports1.attachReporter(sprarkReporter);
		
		sprarkReporter.config().setDocumentTitle("DocumentTitle");
		sprarkReporter.config().setTheme(Theme.DARK);
		sprarkReporter.config().setReportName("Report Name");
		
		extentReports1.setSystemInfo("Executed By", System.getProperty("user.name"));
		extentReports1.setSystemInfo("Executed on OS", System.getProperty("os.name"));
		//extentReports1.setSystemInfo("Executed on Browser", System.getProperty());
		extentReports1.setSystemInfo("Execution Environment", constantValues.URL);
		
		return extentReports1;
	}

}
