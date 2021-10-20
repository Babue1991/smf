package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class Logout_Principal {
public static WebDriver driver;
	@Given("^The principal users screen$")
	public void the_principal_users_screen() throws Throwable {
		driver = DriverClass.initiate();
		driver.get(Constants.dashboard_URL);
	}

	@When("^I click logout button from principal login$")
	public void i_click_logout_button_from_principal_login() throws Throwable {
	
		driver.findElement(By.linkText("Log Out")).click();
	}

	@Then("^The pricipal should be logged out successfully$")
	public void the_pricipal_should_be_logged_out_successfully() throws Throwable {
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expected = driver.findElement(By.id("loginButton")).getText();
		String actual = "Log In";
		Assert.assertEquals(expected, actual);
	
	}

}
