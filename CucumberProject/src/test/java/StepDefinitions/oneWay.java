package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import java.util.Iterator;
import java.util.Set;

import org.junit.runner.RunWith;
import org.testng.Assert;

import PageObjects.OneWay;
import Resources.Base;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(Cucumber.class)
public class oneWay extends Base {

	@Given("^Initialize browser and then Open site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}

	 @Then("^Click on One way Cab option under service$")
	    public void Navigate_to_Site() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 OneWay srv = new OneWay(driver);
			srv.ServiceOneWayClick().click();
			
	 }
	 
	 
	 @When("^Navigate to next window and select a journey$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 OneWay srv = new OneWay(driver);
		 
		  Set <String> ids = driver.getWindowHandles(); //Handling multi windows
		  Iterator<String> it = ids.iterator();
		  it.next();
		  String ChildId = it.next();
		  driver.switchTo().window(ChildId);
		 
		 System.out.println( driver.getTitle());
			
	
		srv.AhmedabadCitySelect().click();
		srv.AhmedabadToVadodara().click();
		  
		
	}
	 

	 @Then("^Navigate to next window and validate the journey selected right$")
	public void User_enters_and_and_logs_in() throws Throwable {
	      
		 OneWay srv = new OneWay(driver);

		  Set <String> idss = driver.getWindowHandles(); //Handling multi windows
		  Iterator<String> its = idss.iterator();
		  its.next();
		  its.next();
		  String ChildIds = its.next();
		  driver.switchTo().window(ChildIds);
		  
		  Thread.sleep(3000);
		  
		  System.out.println(driver.getTitle());
		  
		  System.out.println(srv.TitleOfThePage().getText());
		  Assert.assertEquals(srv.TitleOfThePage().getText(), "/\n"+"Ahmedabad To Vadodara Cabs");

		  Logger log = LogManager.getLogger(oneWay.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Title of one way rental");
	}
	 
	
   
    @And("^Close all browsers4$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
