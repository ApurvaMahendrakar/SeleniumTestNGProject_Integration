package POMCommon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Common {

	POMConfig.ConfigurationPOM config = new POMConfig.ConfigurationPOM();
	// POMConfig.DriverPOM d =new POMConfig.DriverPOM();
	public static WebDriver driver;
	public static Properties p;

	public Common(){
		
		try {
			p=new Properties();
			FileInputStream f=new FileInputStream(config.propertiesFile);
			p.load(f);
			;
		} catch (IOException e) {
	
			e.printStackTrace();
		}
		
	}
	
	
	
	public void openBrowser() throws IOException {

		System.setProperty("webdriver.chrome.driver", "C://browserdrivers//chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(2));
		// FileInputStream f = new FileInputStream(config.propertiesFile);
		// p.load(f);
		driver.manage().window().maximize();
		//driver.get(config.url);
       // System.out.println("url from config properties : " +p.getProperty("url"));
		driver.get(p.getProperty("url"));

	}

	public String[] readCsv(String fpath) throws IOException {
		File f1 = new File(fpath);
		FileReader fr = new FileReader(f1.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);

		String line1 = br.readLine();
		String[] data = line1.split(",");

		System.out.println("Email id from csv : " + data[0]);
		System.out.println("Password from csv  : " + data[1]);
		return data;

	}

	public String[] readCsvforsendingEmail(String fpath) throws IOException, InterruptedException {
		File f1 = new File(fpath);
		FileReader fr = new FileReader(f1.getAbsoluteFile());
		BufferedReader br = new BufferedReader(fr);

		String Line1 = br.readLine();
		String[] data = Line1.split(",");

		System.out.println("email to : " + data[0]);
		System.out.println("email subject is : " + data[1]);

		System.out.println("email message  :" + data[2]);
		Thread.sleep(5000);
		return data;

	}

	public void closeBrowser() {

		driver.quit();

	}

}
