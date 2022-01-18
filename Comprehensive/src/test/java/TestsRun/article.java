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

import PageObjects.Article;
import Resources.Base;

public class article extends Base {

	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get("https://www.savaari.com/");
	}
	
	@Test
	public void runArticle()
	{
		Logger log = LogManager.getLogger(article.class);
        PropertyConfigurator.configure("log4j.properties");
        
		Article a = new Article(driver);
		a.indianexpress().click();
		Set<String> ids=driver.getWindowHandles();
		Iterator<String>it=ids.iterator();
		it.next();
		String Childid=it.next();
		driver.switchTo().window(Childid);
		log.info("Validating headline");
		System.out.println(a.headLine().getText());
		Assert.assertEquals(a.headLine().getText(), "Rent a car to avoid risk of COVID-19 is what office goers seem to prefer");

	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
		driver = null;
	} 
}
