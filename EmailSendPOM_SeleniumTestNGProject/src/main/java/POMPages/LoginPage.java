package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import POMCommon.Common;

public class LoginPage extends Common {

	// POMConfig.DriverPOM d =new POMConfig.DriverPOM();
	Common c = new Common();

	public WebElement email, pass, next1, next2;

	public WebElement getUname() {

		email = c.driver.findElement(By.id("identifierId"));

		return email;

	}

	public WebElement getNext1() {

		next1 = c.driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span"));

		return next1;

	}

	public WebElement getPass() {

		pass = c.driver.findElement(By.name("password"));
		return pass;

	}

	public WebElement getNext2() {

		next2 = c.driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span"));

		return next2;

	}

}
