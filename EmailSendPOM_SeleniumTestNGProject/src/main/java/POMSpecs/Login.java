package POMSpecs;

import java.io.IOException;

import POMCommon.Common;

public class Login  extends Common{
	
	POMCommon.Common comm = new POMCommon.Common();
	POMConfig.ConfigurationPOM config = new POMConfig.ConfigurationPOM();
	POMPages.LoginPage loginPage = new POMPages.LoginPage();
	
		public void validateLogin() throws IOException, InterruptedException {
			
			//read csv and capture data
			//String []data =comm.readCsv(config.filePath);
			String []data =comm.readCsv(p.getProperty("filePath"));
			//pass login credentials
			loginPage.getUname().sendKeys(data[0]);
			loginPage.getNext1().click();
			loginPage.getPass().sendKeys(data[1]);
			loginPage.getNext2().click();
			
			
		}
	      
}
