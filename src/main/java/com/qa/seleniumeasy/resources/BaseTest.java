package com.qa.seleniumeasy.resources;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.seleniumeasy.configFiles.constantValues;
import com.qa.seleniumeasy.utils.ExcelUtil;

@SuppressWarnings("deprecation")
public class BaseTest {

	public ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public ExcelUtil excelUtil;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extentReports;
	public static ExtentTest logger;
	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public static WebDriver currentBrowser;

	// setter
	public void setDriver(WebDriver driver) {
		this.driver.set(driver);
	}

	// getter
	public WebDriver getDriver() {
		return this.driver.get();
	}

	@BeforeTest
	public void beforeTest() {
		// reports
		excelUtil = new ExcelUtil();
		ExtentFactory.getInstance();

	}

	@BeforeMethod
	@Parameters(value = { "browserName" })
	public void beforeMethod(String browserName, Method testCaseName) {
		openBrowser(browserName);

		getDriver().get(constantValues.URL);
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(constantValues.IMPLICIT_WAIT, TimeUnit.SECONDS);
		getDriver().manage().timeouts().pageLoadTimeout(constantValues.PAGE_LOAD, TimeUnit.SECONDS);

	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
//		logger = extentReports.createTest(result.getMethod().getMethodName());
//
//		if (result.getStatus() == ITestResult.SUCCESS) {
//			String methodName = result.getMethod().getMethodName();
//			String logtext = "TestCase " + methodName + " is PassedBulshit";
//			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.GREEN);
//			logger.log(Status.PASS, m);
//		} else if (result.getStatus() == ITestResult.FAILURE) {
//			String methodName = result.getMethod().getMethodName();
//			String logtext = "TestCase " + methodName + " Failedshit";
//			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.RED);
//			logger.log(Status.FAIL, m);
//
//		}
//
//		else if (result.getStatus() == ITestResult.SKIP) {
//			String methodName = result.getMethod().getMethodName();
//			String logtext = "TestCase " + methodName + " Skippedshit";
//			Markup m = MarkupHelper.createLabel(logtext, ExtentColor.YELLOW);
//			logger.log(Status.SKIP, m);
//		} else {
		getDriver().quit();
	}

	@AfterTest
	public void afterTest() {
		// extentReports.flush();
	}

	// generic function
	public void openBrowser(String browserName) {

		// browserName = constantValues.BROWSER;
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
			setDriver(new ChromeDriver());
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
			setDriver(new FirefoxDriver());
		}
		currentBrowser = getDriver();
	}

}
