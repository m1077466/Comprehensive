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

import PageObjects.BlogIcon;
import Resources.Base;

public class blogIcon extends Base {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.savaari.com/");
	}
	
	@Test
	public void runBlog()
	{
		
		Logger log = LogManager.getLogger(blogIcon.class);
        PropertyConfigurator.configure("log4j.properties");
        
		BlogIcon b = new BlogIcon(driver);
		b.Blog().click();
		
		Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
		Iterator<String> it = ids.iterator();                      
		it.next();
		String ChildId = it.next();
		driver.switchTo().window(ChildId);
		log.info("twitter blog");
		System.out.println(b.Bt().getText());
		Assert.assertEquals(b.Bt().getText(), "Savaari Car Rentals");

		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
	
}
