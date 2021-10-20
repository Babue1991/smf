package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Principal_Login {

	public static WebDriver driver;
	@Given("^The principal users username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void the_principal_users_username_and_password(String email1, String password1) throws Throwable {

		driver = DriverClass.initiate();
		driver.get(Constants.URL);
		
		driver.findElement(By.name("email")).click();
	    driver.findElement(By.name("email")).clear();
	    
	    driver.findElement(By.name("email")).sendKeys(email1);
	    driver.findElement(By.name("password")).click();
	    driver.findElement(By.name("password")).clear();
	    driver.findElement(By.name("password")).sendKeys(password1);
	  
	}

	@When("^The principal user clicks login button$")
	public void the_principal_user_clicks_login_button() throws Throwable {
		driver.findElement(By.id("loginButton")).click();

    }

	@Then("^The principal users login should be successful$")
	public void the_principal_users_login_should_be_successful() throws Throwable {
    	Thread.sleep(5000L);
		String response = driver.findElement(By.cssSelector("#main > div > div.head_notification_section > div > div > h1")).getText();
		
		String actual = "Welcome, Principal1";
		Assert.assertEquals(actual, response);
		
    }

}

