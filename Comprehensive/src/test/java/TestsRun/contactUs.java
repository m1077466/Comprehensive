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

import PageObjects.ContactUs;
import Resources.Base;

public class contactUs extends Base {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.savaari.com/");
	}
	
	@Test
	public void runContactUs()
	{
		Logger log = LogManager.getLogger(contactUs.class);
        PropertyConfigurator.configure("log4j.properties");
        
		ContactUs c = new ContactUs(driver);
		c.Contact().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		log.info("Printing contact us information");
		System.out.println(c.Info().getText());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
