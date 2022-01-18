package TestsRun;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.AboutUs;
import PageObjects.ContactUs;
import Resources.Base;

public class aboutUs extends Base {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.savaari.com/");
	}
	
	@Test
	public void runContactUs()
	{
		Logger log = LogManager.getLogger(aboutUs.class);
        PropertyConfigurator.configure("log4j.properties");
        
		AboutUs ab = new AboutUs(driver);
		ab.About().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(ab.AboutusText().getText());
		log.info("CEO name validating");
		System.out.println("The CEO of the savaari.com is = "+ab.CEOName().getText());
		Assert.assertEquals(ab.CEOName().getText(), "Gaurav Aggarwal");
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
