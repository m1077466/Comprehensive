package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CityRental {

	public WebDriver driver;
	
	By cr = By.linkText("Jaipur");
	By from = By.xpath("//*[@id=\"fromCityList\"]");
	
	public CityRental(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}
	
	public WebElement rentalInCity()
	{
		return driver.findElement(cr);
	}
	
	public WebElement From(){
		return driver.findElement(from);
	}
}
