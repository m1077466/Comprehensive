package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OutStation {

public WebDriver driver;
	
	By roundtrip = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/div[2]/label");
	By from = By.id("fromCityList");
	
	By To = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[2]/div/input");
	
	By returnDate = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/input");
    By date = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/div/div/div/div[2]/table/tbody/tr[4]/td[7]/span");
    By selectcar = By.xpath("//button[@class='book-button btn']");
    By rdate = By.xpath("//*[@id=\"approot\"]/mat-sidenav-container/mat-sidenav-content/app-home/div/app-home-container/div[1]/div[1]/div[2]/app-outstation/div/form/div[3]/div[2]/div/p-calendar[1]/span/div/div/div/div[2]/table/tbody/tr[4]/td[5]/span");
    public OutStation(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
	this.driver = driver;
	}

	public WebElement Roundtrip()
	{
		return driver.findElement(roundtrip);
	}
	
	public WebElement From()
	{
		return driver.findElement(from);
	}
	
	
	public WebElement Tocity()
	{
		return driver.findElement(To);
	}

	  public WebElement ReturnDate()
	  { 
		  return driver.findElement(returnDate); 
	  }
	  
	  public WebElement RDate()
	  { 
		  return driver.findElement(rdate); 
	  }
	 
	  public WebElement Date()
	  { 
		  return driver.findElement(date); 
	  }
	  
	  public WebElement Selectcar()
	  { 
		  return driver.findElement(selectcar); 
	  }
}
