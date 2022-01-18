package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OneWay {

	public WebDriver driver;
	By Cabs=By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/app-footer/footer/div[1]/div[2]/ul/li[3]/a");
	By clickCity=By.xpath("//*[@id=\"tabAhmedabad\"]");
	By location=By.xpath("//*[@id=\"west-0\"]/div/a[1]/div[1]");
	
	public OneWay(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
    
	public WebElement OneWayCabText()
	{
		return driver.findElement(Cabs);
		
	}
	
	public WebElement clickCity()
	{
		return driver.findElement(clickCity);
		
	}
	
	public WebElement location()
	{
		return driver.findElement(location);
		
	}
}
