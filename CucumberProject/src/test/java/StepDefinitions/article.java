package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.runner.RunWith;
import org.testng.Assert;

import PageObjects.Article;
import Resources.Base;


@RunWith(Cucumber.class)
public class article extends Base{
	Article fea = new Article(driver);
	 
	@Given("^Initialize the browser and navigate to savaari site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}
	 
	 @When("^Select the One option from featured Section$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 Article fea = new Article(driver);
		 fea.indianexpress().click();
		 Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
		
	}
	 
	 
	 
	 @Then("^Navigate to next page and print the title and Validate the heading$")
		public void User_enters() throws Throwable {
	
		 Article fea = new Article(driver);
			
		  System.out.println(driver.getTitle());	   
	
		  System.out.println(fea.headLine().getText());
		  Assert.assertEquals(fea.headLine().getText(),"Rent a car to avoid risk of COVID-19 is what office goers seem to prefer");
		     
		  Logger log = LogManager.getLogger(article.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Print article headline");
	        
		}


  
    @And("^Close all browsers2$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
