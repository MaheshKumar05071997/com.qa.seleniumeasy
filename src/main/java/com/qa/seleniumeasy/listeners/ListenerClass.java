package com.qa.seleniumeasy.listeners;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.mail.Multipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IAnnotationTransformer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.qa.seleniumeasy.resources.BaseTest;
import com.qa.seleniumeasy.resources.ExtentFactory;
import com.qa.seleniumeasy.resources.ExtentReportNG;

public class ListenerClass extends BaseTest implements ITestListener, IAnnotationTransformer {

	static ExtentReports report;
	// ThreadLocal<ExtentTest> test = new ThreadLocal<ExtentTest>();
	ExtentTest test;
	Object currentInstance;
	String screenShotPath;

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		test = report.createTest(result.getMethod().getMethodName());
		ExtentFactory.getInstance().setExtent(test);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ExtentFactory.getInstance().getExtent().log(Status.PASS,
				"Test Case " + result.getMethod().getMethodName() + " is Passed");
		ExtentFactory.getInstance().removeExtentObject();
	}

	@Override
	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub

		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
		Date date = new Date();
		String actualDate = format.format(date);
		ExtentFactory.getInstance().getExtent().log(Status.FAIL,
				"Test Case " + result.getMethod().getMethodName() + " is Failed");

		screenShotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator
				+ result.getMethod().getMethodName() + ".jpeg";
		File dest = new File(screenShotPath);
		currentInstance = result.getInstance();

		File src = ((TakesScreenshot) ((BaseTest) currentInstance).getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			// ExtentFactory.getInstance().getExtent().addScreenCaptureFromPath(screenShotPath);
			ExtentFactory.getInstance().getExtent().fail(
					"<b><font color=red>" + "Screenshot of Failure" + "</font></b>",
					MediaEntityBuilder.createScreenCaptureFromPath(screenShotPath).build());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			sendEmail();
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ExtentFactory.getInstance().getExtent().log(Status.FAIL, result.getThrowable());
		ExtentFactory.getInstance().removeExtentObject();

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		ExtentFactory.getInstance().getExtent().log(Status.SKIP,
				"Test Case " + result.getMethod().getMethodName() + " is Skipped");
		ExtentFactory.getInstance().removeExtentObject();

	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

		report = ExtentReportNG.setupExtentReports();

	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush();

	}

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		// TODO Auto-generated method stub
		annotation.setRetryAnalyzer(RetryAnalyzer.class);

	}

	public void sendEmail() throws EmailException {
		// create the attachment
		EmailAttachment attachment = new EmailAttachment();
		attachment.setPath("com.qa.seleniumeasy/reports/");
		attachment.setDisposition(EmailAttachment.ATTACHMENT);
		attachment.setDescription("Report of Execution");
		attachment.setName("Automation Reports");

		// create the email message

		MultiPartEmail email = new MultiPartEmail();
		email.setHostName("smtp.gmail.com");
		email.setSmtpPort(465);
		email.setAuthenticator(new DefaultAuthenticator("aditya.adiverma.verma@gmail.com", "qnjgalcnevonpkus"));
		email.setSSLOnConnect(true);
		email.addTo("aditya.adiverma.verma@gmail.com", "Mahesh Kumar Vishwakarma");
		email.setFrom("Mahesh@gmail.com", "Me");
		email.setSubject("Automation Reports");
		email.setMsg("Test automation report");

		// add the attachment
		email.attach(attachment);

		// send the mail
		email.send();
		
		System.out.println("=============Email sent boss======================");
		System.out.println("=============Email sent boss again======================");
	}

}
