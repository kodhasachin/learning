package pom;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GmailTest{
	
	static WebDriver driver;
	
	public static void get_driver() throws Exception
	{
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.firefox());
		driver.get("http://www.google.com");
	}
	

	public static void main(String[] args) {
		//get_driver();

	}

}
