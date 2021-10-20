package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Login_Success {

	public static WebDriver driver;
	@Given("^The valid login input payload with \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_valid_login_input_payload_with_something_something(String email1, String password1) throws Throwable {
		driver = DriverClass.initiate();
		
		driver.get(Constants.URL);
		
		driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    
	    driver.findElement(By.name("email")).sendKeys(email1);
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(password1);
	  
	}

    @When("^The user clicks login button$")
    public void the_user_clicks_login_button() throws Throwable {
		driver.findElement(By.id("loginButton")).click();

    }

    @Then("^The login should be successful$")
    public void the_login_should_be_successful() throws Throwable {
    	Thread.sleep(5000L);
		String response = driver.findElement(By.cssSelector("#main > div > div.head_notification_section > div > div > h1")).getText();
		
		String actual = "Welcome, Kristopher Hoppe DVM";
		Assert.assertEquals(response, actual);
		
    }

}
