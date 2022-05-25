package POMSpecs;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import POMCommon.Common;

public class SendEmail extends Common{

	POMSpecs.AttachFile attachfile = new POMSpecs.AttachFile();
	POMConfig.ConfigurationPOM config = new POMConfig.ConfigurationPOM();
	POMCommon.Common comm = new POMCommon.Common();
	POMPages.SendEmailPage emailPage = new POMPages.SendEmailPage();
	Common d = new Common();

	public void sendEmail() throws IOException, InterruptedException, AWTException {

		d.driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(10));
		emailPage.getGoogleApp().click();

		// Switch to frame
		d.driver.switchTo().frame(0);
		emailPage.getGmail().click();
		d.driver.switchTo().defaultContent();

		// handing window
		Set<String> s1 = d.driver.getWindowHandles();
		System.out.println("child window is " + s1);
		Iterator<String> i1 = s1.iterator();

		while (i1.hasNext()) {
			String ChildWindow = i1.next();
			System.out.println("title" + d.driver.switchTo().window(ChildWindow).getTitle());
			Thread.sleep(5000);
		}

		emailPage.getCompose().click();
		emailPage.getCloseNotification().click();
		String[] data = comm.readCsvforsendingEmail(p.getProperty("sendtoemail"));
		//String[] data = comm.readCsvforsendingEmail(config.sendtoemail);
		emailPage.getEmailTo().sendKeys(data[0]);
		emailPage.getEmailSubject().sendKeys(data[1]);
		emailPage.getEmailBody().sendKeys(data[2]);
		emailPage.getFileIcon().click();
		attachfile.attachFile();

	}

}
