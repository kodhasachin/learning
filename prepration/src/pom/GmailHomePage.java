package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GmailHomePage {
	
	private WebDriver driver;
	
	@FindBy(xpath="")
	WebElement username;
	
	@FindBy(xpath="")
	WebElement passowrd;
	
	@FindBy(xpath="")
	WebElement login_btn;
	
	public GmailHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
