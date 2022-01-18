package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BlogIcon {

	public WebDriver driver;
	
	By bi = By.className("bg-twitter");
	By BlogTitle = By.xpath("//*[@id=\"react-root\"]/div/div/div[2]/main/div/div/div/div/div/div[2]/div/div/div[1]/div/div[2]/div/div/div[1]/div/span[1]/span");
	
	public BlogIcon(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public WebElement Blog()
	{
		return driver.findElement(bi);
	}
	
	public WebElement Bt()
	{
		return driver.findElement(BlogTitle);
	}
}
