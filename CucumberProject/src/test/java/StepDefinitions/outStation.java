package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import Resources.Base;
import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;

import PageObjects.OutStation;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(Cucumber.class)
public class outStation extends Base {

	@Given("^Initialize the browser$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
	    
	}

	 @Then("^Navigate to \"([^\"]*)\" site on$")
	    public void Navigate_to_Site(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 driver.get(arg1);
			
	 }
	 
	 
	 @When("^Select the Round Trip checkBox$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 OutStation os = new OutStation(driver);
		 
		 os.Roundtrip().click();
		  
		
	}
	 

	 @Then("^User enters From City (.+)$")
	public void User_enters_and_and_logs_in(String arg1) throws Throwable {
	      
		 OutStation os = new OutStation(driver);
		 os.From().sendKeys(arg1);
		 Thread.sleep(2000);
		 os.From().sendKeys(Keys.ARROW_DOWN);
		 os.From().sendKeys(Keys.ARROW_DOWN);
		 os.From().sendKeys(Keys.ENTER);
			
	}
	 
	 
	 @Then("^User enters To City Details (.+)$")
		public void User_enters(String arg2) throws Throwable {
		      
		 OutStation os = new OutStation(driver);
		    os.Tocity().sendKeys(arg2);
		    Thread.sleep(3000);
		    os.Tocity().sendKeys(Keys.ARROW_DOWN);
		    os.Tocity().sendKeys(Keys.ARROW_DOWN);
		    os.Tocity().sendKeys(Keys.ENTER);
			
				
		}
    
    @Then("^Display the title of the selected car and select the summit button$")
    public void Verifyth() throws Throwable {
    	
    	OutStation os = new OutStation(driver);
    	System.out.println(os.Selectcar().getText());
    	os.Selectcar().click();
          
    	Logger log = LogManager.getLogger(outStation.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Verify outsation car");
    }
    
   
    @And("^Close browserss$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    
    }
}
