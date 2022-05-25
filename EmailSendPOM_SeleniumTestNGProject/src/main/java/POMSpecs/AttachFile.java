package POMSpecs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POMCommon.Common;

public class AttachFile extends Common {

	POMPages.SendEmailPage emailPage = new POMPages.SendEmailPage();
	POMConfig.ConfigurationPOM config = new POMConfig.ConfigurationPOM();
	// POMConfig.DriverPOM d =new POMConfig.DriverPOM();
	Common c = new Common();

	public void attachFile() throws InterruptedException, AWTException {

		c.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		Robot rb = new Robot();
		//StringSelection ss = new StringSelection(p.getProperty("attachFile"));
		
	StringSelection ss = new StringSelection(config.attachFile);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL); //
		rb.keyPress(KeyEvent.VK_V); //
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		// enter key
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		WebElement attFile = c.driver.findElement(By.className("vI"));
		String actDoc = attFile.getText();
		System.out.println("Get Actual File name for verification :" + attFile.getText());
		String expDocument = "demo.txt";
		System.out.println("Expected File name  :" + expDocument);
		if (expDocument.equals(actDoc)) {

			System.out.println("document upload successfully...document verification done..Test is Passed");
			emailPage.getSendBtn().click();

			System.out.println("email sent successfully");
			//c.driver.get(config.senturl);
			c.driver.get(p.getProperty("senturl"));

			boolean sent = c.driver.getPageSource().contains("Selenium project Demo1");
			if (sent) {
				System.out.println("email verification sucessfully..Test is Passed");
			} else {
				System.out.println("email verification failed..Test is failed");
			}
		} else {
			System.out.println("document upload failed...!!!!...Test is failed");
		}

	}

}