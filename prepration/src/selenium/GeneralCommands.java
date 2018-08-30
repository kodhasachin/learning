package selenium;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GeneralCommands {
	
	public static WebDriver driver;
	@Test
	@Parameters("browsertype")
	public static void get_url(String url)
	{
		DesiredCapabilities caps = new DesiredCapabilities();
		
		System.setProperty("webdriver.chrome.driver", "/Users/skodha/sachin/softwares/Selenium/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
//		driver.close();
//		driver.quit();
		
	}
	
	public static void find_searchtext(WebDriver driver)
	{
		driver.findElement(By.xpath("//u[contains(text(),'rediffmail')]")).click();
		Set<String> handles = driver.getWindowHandles();
		System.out.println("Handles size is: "+handles.size());
		
		
		driver.quit();
		
	}
	

	public static void main(String[] args) {
		
		get_url("http://www.rediff.com");
		find_searchtext(driver);
	}

}
