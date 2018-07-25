package learning;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeWebDriver {
	
	
	

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "/Users/skodha/sachin/softwares/Selenium/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.google.com");
		driver.quit();
		
		// TODO Auto-generated method stub

	}

}
