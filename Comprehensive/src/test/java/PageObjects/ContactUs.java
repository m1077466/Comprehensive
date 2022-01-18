package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {

	public WebDriver driver;
	
	By cu = By.linkText("Contact Us");
	By info=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]");
	
	
	public ContactUs(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement Contact()
	{
		return driver.findElement(cu);
	}
	
	public WebElement Info()
	{
		return driver.findElement(info);
	}
}
