package StepDefinitions;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.junit.Cucumber;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;

import PageObjects.ContactUs;

import Resources.Base;

@RunWith(Cucumber.class)
public class contactUs extends Base {

	@Given("^Open the site by browser initialization$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}

	 @Then("^Click Contact us$")
	    public void Navigate_to_Site() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 ContactUs cs = new ContactUs(driver);
		 cs.ContactUsClick().click();
			
	 }
		
	 @When("^Navigate to next window and get the mail id$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 ContactUs cs = new ContactUs(driver);
		 
		 Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
		    System.out.println(cs.SendUsMailText().getText());
		    System.out.println(cs.mailIDText().getText());
		    
		    Logger log = LogManager.getLogger(contactUs.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Print mail id to contact");
	}
 
	
   
    @And("^Close all browsers5$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
