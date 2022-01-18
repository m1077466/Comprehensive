package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;

import PageObjects.SignIn;
import Resources.Base;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RunWith(Cucumber.class)
public class signInF extends Base {

	@Given("^Initialize the browser with chrome$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
	    
	}

	 @Given("^Navigate to \"([^\"]*)\" Site$")
	    public void Navigate_to_Site(String arg1) throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 driver.get(arg1);
			
	 }
	 
	 
	 @Given("^Click on SignIn Icon and Sign In popUp Comes$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 SignIn sd = new SignIn(driver);
		 
		 sd.Sign().click();
		  
		
	}
	 

	 @When("^User enters wrong (.+) and (.+) and try to Signs in$")
	public void User_enters_and_and_logs_in(String arg1 , String arg2) throws Throwable {
	      
		 SignIn sd = new SignIn(driver);
		 sd.Email().sendKeys(arg1);
		 sd.Pass().sendKeys(arg2);
		 sd.Login().click();
			
	}


    @Then("^Verify the error message is printing$")
    public void Verify() throws Throwable {
    	
    	SignIn sd = new SignIn(driver);
    	System.out.println(sd.Error().isDisplayed());
		System.out.println(sd.Error().getText());
            
		Logger log = LogManager.getLogger(signInF.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("signing in");
               
    }
    
    @And("^Close browsers$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
