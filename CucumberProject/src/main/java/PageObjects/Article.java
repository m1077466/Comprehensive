package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Article {

	public WebDriver driver;
	
	 By photo = By.xpath("//img[@src='assets/img/indian-express.jpg']");
	 By Headline = By.id("content_head");
	 
	 public Article(WebDriver driver) 
		{
			// TODO Auto-generated constructor stub
			this.driver = driver;
		}
	 
	 public WebElement indianexpress()
	 {
		 return driver.findElement(photo);
	 }
	 
	 public WebElement headLine()
		{
			return driver.findElement(Headline);
		}
}
