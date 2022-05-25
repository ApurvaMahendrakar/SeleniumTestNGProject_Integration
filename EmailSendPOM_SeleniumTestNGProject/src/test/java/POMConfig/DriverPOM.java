package POMConfig;

import java.awt.AWTException;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import POMCommon.Common;

public class DriverPOM extends Common {

	POMConfig.ConfigurationPOM config = new POMConfig.ConfigurationPOM();
	// POMCommon.Common comm = new POMCommon.Common();
	POMSpecs.Login login = new POMSpecs.Login();
	POMSpecs.SendEmail sendEmail = new POMSpecs.SendEmail();

	@BeforeTest
	public void openBrowserTest() throws IOException {
		openBrowser();

	}

	@Test
	public void loginTest1() throws IOException, InterruptedException {
		login.validateLogin();
	}

	@Test(dependsOnMethods = { "loginTest1" })
	public void sendEmailTest2() throws IOException, InterruptedException, AWTException {
		sendEmail.sendEmail();
	}

	@AfterMethod
	public void takeScreeshot(ITestResult result) throws IOException {

		if (ITestResult.FAILURE == result.getStatus()) {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(".\\Screenshots\\" + result.getName() + ".png"));
			System.out.println("Successfully capture a Screenshot");

		}

	}

	@AfterTest
	public void closeDriverTest() throws IOException, InterruptedException, AWTException {
		// closeBrowser();
	}

}
