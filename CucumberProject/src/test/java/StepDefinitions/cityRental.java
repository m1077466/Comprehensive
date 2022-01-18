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

import PageObjects.CityRental;
import Resources.Base;

@RunWith(Cucumber.class)
public class cityRental extends Base {

	@Given("^initialize the chrome Open the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}

	 @Then("^Click on the city in the bottom car rental bar$")
	    public void Navigate_to_Site() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 CityRental cr = new CityRental(driver);
		 cr.CitySelection().click();
			
	 }
	 
	 
	 @When("^Navigate to next window and check the correct city is selected$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 CityRental cr = new CityRental(driver);
		 
			Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			System.out.println( cr.FromCityText().getText());
	}
	 

	 @Then("^Click on travel guide and print the pune details in console$")
	public void User_enters_and_and_logs_in() throws Throwable {
	      
		 CityRental cr = new CityRental(driver);

		 cr.TravelGuideTab().click();
			
			System.out.println(cr.AboutPuneHeading().getText());
			System.out.println(cr.PuneTextBox().getText());
			Logger log = LogManager.getLogger(cityRental.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Print city selected name where rented");
	}
	 
	
   
    @And("^Close all browsers7$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
