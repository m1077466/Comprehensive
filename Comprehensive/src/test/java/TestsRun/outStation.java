package TestsRun;

import java.io.IOException;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.OutStation;
import Resources.Base;

public class outStation extends Base{

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void MainHomePage()  throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		Logger log = LogManager.getLogger(outStation.class);
        PropertyConfigurator.configure("log4j.properties");
        
		OutStation os = new OutStation(driver);
		os.Roundtrip().click();
		os.From().sendKeys("Udaipur");
		Thread.sleep(2000);
		os.From().sendKeys(Keys.ENTER);
		
		Thread.sleep(2000);
		os.Tocity().sendKeys("Jaipur");
		Thread.sleep(2000);
		os.Tocity().sendKeys(Keys.ARROW_DOWN);
		os.Tocity().sendKeys(Keys.ENTER);
		
		os.ReturnDate().click();
		os.RDate().click();
		
		os.Date().click();
		os.Selectcar().click();
		log.info("Out station verify");
			
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
