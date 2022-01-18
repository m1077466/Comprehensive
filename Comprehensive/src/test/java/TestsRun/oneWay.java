package TestsRun;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.OneWay;
import Resources.Base;

public class oneWay extends Base{

	@BeforeTest
	public void intialize() throws IOException
	{
         driver = initializeDriver();			
	}
	
	@Test
	public void MainHomePage()  throws IOException, InterruptedException
	{
		driver.get(prop.getProperty("url"));      //We defined it here just because we have to access 2 time this site for different set of credentials 
	
		Logger log = LogManager.getLogger(oneWay.class);
        PropertyConfigurator.configure("log4j.properties");
        
		OneWay Oc = new OneWay(driver);
		Oc.OneWayCabText().click();
		
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		System.out.println(driver.getTitle());
		
		Oc.clickCity().click();
		Oc.location().click();
		System.out.println(Oc.location().getText());
		
		Set<String> ids1=driver.getWindowHandles();
		Iterator<String>it1=ids1.iterator();
		it1.next();
		it1.next(); 
		String Childid1=it1.next();
		driver.switchTo().window(Childid1);
		Thread.sleep(3000);
		
		log.info("Validating title");
		System.out.println(driver.getTitle());
	}   
}
