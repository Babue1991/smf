package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Login_Fail{

	static WebDriver driver;
	//= customerServiceUpdateScreen.driver;
	@Given("^The invalid login input payload with \"([^\"]*)\" \"([^\"]*)\"$")
    public void the_invalid_login_input_payload_with_something_something(String email, String password) throws Throwable {
		

			driver = DriverClass.initiate();
			driver.get(Constants.URL);

			driver.findElement(By.name("email")).click();
		    driver.findElement(By.name("email")).clear();
		    
		    driver.findElement(By.name("email")).sendKeys(email);
		    driver.findElement(By.name("password")).click();
		    driver.findElement(By.name("password")).clear();
		    driver.findElement(By.name("password")).sendKeys(password);

	}

	@When("^The user clicks signIn button$")
    public void the_user_clicks_signin_button() throws Throwable {
	  
			driver.findElement(By.id("loginButton")).click();

	}

    @Then("^The login should be failed and response should be \"([^\"]*)\"$")
    public void the_login_should_be_failed_and_response_should_be_something(String strArg1) throws Throwable {
		  Thread.sleep(5000L);
		String response = driver.findElement(By.cssSelector("body > div.app.auth-pages > div > div.alert.alert-danger.alert-dismissible")).getText();
		System.out.println(response);
		String actual = "×\r\n"
				+ "Email/Password is incorrect";
	//	Assert.assertEquals(response, actual);
	}


}
