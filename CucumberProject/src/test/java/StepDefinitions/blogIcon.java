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

import PageObjects.BlogIcon;
import Resources.Base;


@RunWith(Cucumber.class)
public class blogIcon extends Base{

	@Given("^initialize the browser and Open the site$")
	public void Initialize_the_browser_with_chrome() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		 driver = initializeDriver();
		 driver.get(prop.getProperty("url"));
	    
	}

	 @Then("^Click on the Blogger icon$")
	    public void Navigate_to_Site() throws Throwable {
		    // Write code here that turns the phrase above into concrete actions
		 BlogIcon sb = new BlogIcon(driver);
		 sb.BloggerIconClick().click();
			
	 }
	 
	 
	 @When("^Navigate to next window and click on travel guide$")
	    public void Click_on_SignIn_Icon() throws Throwable {
		 BlogIcon sb = new BlogIcon(driver);
		 
		 Set <String> ids = driver.getWindowHandles();             //Handling multi windows 
			Iterator<String> it = ids.iterator();                      
			it.next();
			String ChildId = it.next();
			driver.switchTo().window(ChildId);
			
			sb.TravelGuideClick().click();
		
	}
	 

	 @Then("^Print the article heading in console$")
	public void User_enters_and_and_logs_in() throws Throwable {
	      
		 BlogIcon sb = new BlogIcon(driver);

		 System.out.println(sb.pondicherryText().getText());
			
			sb.pondicherryText().click();
			
			System.out.println(sb.BlogTitleValidate().getText());
			
			Logger log = LogManager.getLogger(blogIcon.class);
	        PropertyConfigurator.configure("log4j.properties");
	        log.info("Print twitter title");
	}
	 
    @And("^Close all browsers6$")
    public void Close_browsers() throws Throwable {
    	driver.quit();
    }
}
