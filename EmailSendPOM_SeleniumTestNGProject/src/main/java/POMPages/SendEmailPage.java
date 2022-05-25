package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import POMCommon.Common;

public class SendEmailPage {

	// POMConfig.DriverPOM d =new POMConfig.DriverPOM();
	Common c = new Common();
	public WebElement google_apps, gmail, compose, close, to, subject, emailbody, fileicon, send, mail, sent;

	public WebElement getGoogleApp() {

		google_apps = c.driver.findElement(By.xpath("//*[@id=\"gbwa\"]"));

		return google_apps;

	}

	public WebElement getGmail() {

		gmail = c.driver.findElement(By.xpath("//*[@id=\"yDmH0d\"]/c-wiz/div/div/c-wiz/div/div/ul[1]/li[2]/a/span"));

		return gmail;

	}

	public WebElement getCompose() {

		compose = c.driver.findElement(By.cssSelector(".T-I.T-I-KE.L3"));
		return compose;

	}

	public WebElement getCloseNotification() {

		close = c.driver.findElement(By.xpath("/html/body/div[17]/div[2]/div[3]/button[3]"));

		return close;

	}

	public WebElement getEmailTo() {

		to = c.driver.findElement(By.name("to"));

		return to;

	}

	public WebElement getEmailSubject() {

		subject = c.driver.findElement(By.name("subjectbox"));

		return subject;

	}

	public WebElement getEmailBody() {

		emailbody = c.driver.findElement(By.cssSelector(".Ar.Au div"));

		return emailbody;

	}

	public WebElement getFileIcon() {

		fileicon = c.driver.findElement(By.cssSelector(".a1.aaA.aMZ"));

		return fileicon;

	}

	public WebElement getSendBtn() {

		send = c.driver.findElement(By.className("btA"));

		return send;

	}

	public WebElement getMail() {

		mail = c.driver.findElement(By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]/div[1]/div[2]/div[1]/div"));

		return mail;

	}

	public WebElement getSent() {

		sent = c.driver.findElement(By.xpath("//div[@id=':kr']/div/div[2]"));

		return sent;

	}
}
