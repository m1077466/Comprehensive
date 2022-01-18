package StepDefinitions;

import java.util.Iterator;
import java.util.Set;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.runner.RunWith;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import PageObjects.AboutUs;
import Resources.Base;


@RunWith(Cucumber.class)
public class aboutUs extends Base {

	@Given("^Initialize the browser , navigate to the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}
	 
	 @When("^Select the About Us Option$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 AboutUs Abu = new AboutUs(driver);
		 Abu.About().click();
	}
	 
	 
	 
	 @Then("^Navigate to next page and print all the details$")
		public void User_enters() throws Throwable {
	
		 AboutUs Abu = new AboutUs(driver);
			
		 Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			System.out.println(Abu.AboutusText().getText());
				
		}
	 
	 @Then("^validate the CEO name$")
		public void User_enterss() throws Throwable {
	
		 AboutUs Abu = new AboutUs(driver);
			

			System.out.println("The CEO of the company is = " +Abu.CEOName());
			
			Assert.assertEquals(Abu.CEOName().getText(), "Gaurav Aggarwal");
			
			Logger log = LogManager.getLogger(aboutUs.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Print ceo name");

		}


  
    @And("^Close all browser$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
