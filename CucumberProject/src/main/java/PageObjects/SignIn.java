package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SignIn {
	
	public WebDriver driver;
	
	By si = By.className("bg-signin");
	By email = By.xpath("//input[@type='email']");
	By pass = By.xpath("//input[@type='password']");
	By login = By.className("theme-button");
	By errormessage = By.xpath("//*[@id=\"approot\"]/app-navbar/div[2]/div/div[2]/form/div[3]/div");
	
			//constructor
	public SignIn(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement Sign()
	{
		return driver.findElement(si);
	}
	
	public WebElement Email()
	{
		return driver.findElement(email);
	}
	
	public WebElement Pass()
	{
		return driver.findElement(pass);
	}
	
	public WebElement Login()
	{
		return driver.findElement(login);
	}
	
	public WebElement Error()
	{
		return driver.findElement(errormessage);
	}
}
