package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;

import org.junit.runner.RunWith;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import PageObjects.Airport;
import Resources.Base;

import org.apache.log4j.PropertyConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
@RunWith(Cucumber.class)
public class airportTab extends Base{

	@Given("^Initialize the browser and opens site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}
	 
	 @When("^Select the Airport box$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 Airport air = new Airport(driver);
		 air.AirportClickForDetails().click();
		  
		
	}
	 

	 @Then("^User enters CityName (.+) and User selects trip type$")
	public void User_enters_and_and_logs_in(String CityName) throws Throwable {
	      
		 Airport air = new Airport(driver);
		 air.FromCityDetail().sendKeys(CityName);
			Thread.sleep(2000);
			air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
			air.FromCityDetail().sendKeys(Keys.ARROW_DOWN);
			air.FromCityDetail().sendKeys(Keys.ENTER);
			
			air.TripTypeSelection().click();
			Thread.sleep(2000);
			air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
			air.TripTypeSelection().sendKeys(Keys.ARROW_DOWN);
			air.TripTypeSelection().sendKeys(Keys.ENTER);
			
	}
	 
	 
	 @Then("^User enters pickup location (.+) and User selects pickup time and summit$")
		public void User_enters(String pickup) throws Throwable {
		      
		 Airport air = new Airport(driver);
		 air.PickUpLocation().sendKeys(pickup);
			Thread.sleep(7000);
			air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
			air.PickUpLocation().sendKeys(Keys.ARROW_DOWN);
			air.PickUpLocation().sendKeys(Keys.ENTER);
			
			air.PickupTime().click();
			Thread.sleep(2000);
			air.PickupTime().sendKeys(Keys.ARROW_DOWN);
			air.PickupTime().sendKeys(Keys.ARROW_DOWN);
			air.PickupTime().sendKeys(Keys.ENTER);
			
			air.SummitButton().click();

			
				
		}


    @Then("^Navigate to next page gets car name and validate and summit$")
    public void Verify() throws Throwable {
    	
    	Airport air = new Airport(driver);
    	System.out.println(driver.getTitle());
    	   System.out.println(air.SelectedCarName().getText());
   	    Assert.assertEquals(air.SelectedCarName().getText(), "Toyota Innova Crysta");
   	    air.SelectButton().click();
            
               
    }
    
    @Then("^Navigate to next page and fill the name (.+) email (.+) number (.+)$")
    public void Verifyth(String name  , String email   , String number) throws Throwable {
    	
    	Airport air = new Airport(driver);
    	 air.NameDetailsFill().sendKeys(name);
 	    air.EmailFillDetails().sendKeys(email);
 	    air.MobileNumber().sendKeys(number);
 	   
              
    }
    
    @Then("^Unchecked the whatsapp notification check box and summit$")
    public void Verifythererer() throws Throwable {
    	
    	Airport air = new Airport(driver);
    	 air.WhatsappNotiCheckBox().click();
  	    air.ProceedButton().click();	

              
    }
    
    @Then("^Prints the details of the ride in console$")
    public void Verifythwwww() throws Throwable {
    	
    	Airport air = new Airport(driver);
    	 System.out.println(air.PaymentTabCheck().isDisplayed());
 	    System.out.println(air.BookingDetailsDisplay().getText());
           
 	   Logger log = LogManager.getLogger(airportTab.class);
       PropertyConfigurator.configure("log4j.properties");
       log.info("validate airport rent");
    }
    
   
    @And("^Close all browsers1$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    	
    }
}
