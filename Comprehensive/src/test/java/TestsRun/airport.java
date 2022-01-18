package TestsRun;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.Airport;
import Resources.Base;

public class airport extends Base {

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void MainHomePage()  throws IOException, InterruptedException
	{
		Logger log = LogManager.getLogger(airport.class);
        PropertyConfigurator.configure("log4j.properties");
        
		driver.get(prop.getProperty("url"));      
		Airport At = new Airport(driver);
		At.AirpotTab().click();
		At.CityTab().sendKeys("New Delhi");
		Thread.sleep(2000);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		At.CityTab().sendKeys(Keys.ARROW_DOWN);
		At.CityTab().sendKeys(Keys.ENTER);
		
		At.Trip().click();
		At.Trip().sendKeys(Keys.ARROW_DOWN);
		At.Trip().sendKeys(Keys.ENTER);
		
		At.dropAddress().sendKeys("Jaipur");
		Thread.sleep(2000);
		At.dropAddress().sendKeys(Keys.ARROW_DOWN);
		At.dropAddress().sendKeys(Keys.ENTER);
		
		At.Calender().click();
		Thread.sleep(2000);
		At.Time().click();
		At.SelectCar().click();
		
		System.out.println(At.carText().getText());
		At.carSelect().click();
		log.info("Validating car");
		Assert.assertEquals(At.carverify().getText(),"Toyota Etios or Equivalent");
		System.out.println(At.carverify().getText());
		
		At.Name().sendKeys("Muskaan");
		At.Email().sendKeys("abc@gmail.com");
		At.Mobile().sendKeys("1234567890");
		At.pickupterminal().click();
		Thread.sleep(2000);
		At.pickupterminal().sendKeys(Keys.ARROW_DOWN);
		At.pickupterminal().sendKeys(Keys.ARROW_DOWN);
		At.pickupterminal().sendKeys(Keys.ENTER);
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
