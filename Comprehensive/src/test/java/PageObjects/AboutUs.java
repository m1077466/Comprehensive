package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AboutUs {

public WebDriver driver;
	
	By au = By.linkText("About Us");
	By aboutusText = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-about-us/div[3]/div/div[2]");
	By ceoname = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-about-us/div[3]/div/div[3]");
	
	
	public AboutUs(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement About()
	{
		return driver.findElement(au);
	}
	
	public WebElement AboutusText()
	{
		return driver.findElement(aboutusText);
	}
	
	public WebElement CEOName()
	{
		return driver.findElement(ceoname);
	}
}
