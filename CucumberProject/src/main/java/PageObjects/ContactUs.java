package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ContactUs {

	public WebDriver driver;
	

	By ContactUs = By.xpath("//a[@routerlink='/contact-us']");
	
	By SendUsMail = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-contact-us/div[3]/div/div[1]/div[1]/div[1]");
	By mailID   = By.xpath("//a[@href='info@savaari.com']");
	
	
	public ContactUs(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	
	public WebElement ContactUsClick()
	{
		return driver.findElement(ContactUs);
	}
	
	public WebElement SendUsMailText()
	{
		return driver.findElement(SendUsMail);
	}
	
	public WebElement mailIDText()
	{
		return driver.findElement(mailID);
	}
	

}
