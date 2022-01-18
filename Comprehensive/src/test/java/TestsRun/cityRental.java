package TestsRun;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.CityRental;
import Resources.Base;

public class cityRental extends Base{

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.savaari.com/");
	}
	
	@Test
	public void runCityRental()
	{
		Logger log = LogManager.getLogger(cityRental.class);
        PropertyConfigurator.configure("log4j.properties");
        
		CityRental ci = new CityRental(driver);
		ci.rentalInCity().click();
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		log.info("City Rental");
		System.out.println(ci.From().getText());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
	
}
