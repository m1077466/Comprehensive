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

import PageObjects.LocalTab;
import Resources.Base;

public class localTab extends Base{

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();	
         driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void MainHomePage()  throws IOException, InterruptedException
	{	
		Logger log = LogManager.getLogger(localTab.class);
        PropertyConfigurator.configure("log4j.properties");
        
		LocalTab lt = new LocalTab(driver);
		lt.local().click();
		lt.localcity().sendKeys("Mumbai");
		lt.ClickForcity().click();		
		lt.Time().click();
		lt.Time().sendKeys(Keys.ARROW_DOWN);
		lt.Time().sendKeys(Keys.ENTER);	
		
		lt.SelectCar().click();
		System.out.println(lt.CarNamedisplay().getText());
		log.info("Checking Car");
		lt.CarName().click();
		Assert.assertEquals(lt.CarVerify().getText(),"Honda City or Equivalent");
		System.out.println(lt.CarVerify().getText());
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
