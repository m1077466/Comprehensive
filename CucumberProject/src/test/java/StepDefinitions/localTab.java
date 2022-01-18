package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObjects.LocalTab;
import Resources.Base;

@RunWith(Cucumber.class)
public class localTab extends Base {

	@Given("^Initialize the browser and navigate to site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}
	 
	 @When("^Select the Local box$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 LocalTab lc = new LocalTab(driver);
		 
		 System.out.println(driver.getTitle());

			lc.LocalTabSelection().click();
		  
		
	}
	 

	 @Then("^User enters City (.+) and User selects the date$")
	public void User_enters_and_and_logs_in(String arg1) throws Throwable {
	      
		 LocalTab lc = new LocalTab(driver);
		 WebElement FromCity = lc.FromCitySelection();
		    lc.FromCitySelection().sendKeys(arg1);
			Thread.sleep(3000);
			FromCity.sendKeys(Keys.ARROW_DOWN);
			FromCity.sendKeys(Keys.ENTER);
			
			
			lc.PickUpDate().click();
			lc.DateSelect().click();
			
	}
	 
	 
	 @Then("^user select the time of travel and summit the details$")
		public void User_enters() throws Throwable {
		      
		 LocalTab lc = new LocalTab(driver);
		    lc.PickUpAt().click();
			lc.PickUpTime().click();
			lc.SubmitDetails().click();

			
				
		}


    @Then("^Change the hr and km details and Check the car Name$")
    public void Verify() throws Throwable {
    	
    	LocalTab lc = new LocalTab(driver);
    	System.out.println(driver.getTitle());
		lc.HrSelection().click();
		
		System.out.println(lc.CarTypeSelection().getText());
		Assert.assertEquals(lc.CarTypeSelection().getText() ,"Toyota Etios");		
		lc.SelectCar().click();
            
               
    }
    
    @Then("^Navigate to next page and checks the title$")
    public void Verifyth() throws Throwable {
    	
    	LocalTab lc = new LocalTab(driver);
    	System.out.println(driver.getTitle());
		System.out.println(lc.TitleRead().getText());
		 
		Assert.assertEquals(lc.TitleRead().getText() ,"1. Contact & Pickup Details");		

		Logger log = LogManager.getLogger(localTab.class);
        PropertyConfigurator.configure("log4j.properties");
        log.info("Local car rent");  
    }
    
   
    @And("^Close all browsers$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
