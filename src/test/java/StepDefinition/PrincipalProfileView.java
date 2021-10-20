package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class PrincipalProfileView {
public static WebDriver driver;
String expected;
	@Given("^The principal profile screen$")
	public void the_principal_profile_screen() throws Throwable {
		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);
	}

	@When("^I get principal profile name from profile screen$")
	public void i_get_principal_profile_name_from_profile_screen() throws Throwable {
		driver.findElement(By.linkText("Profile")).click();
		expected = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div[1]/div/div/div[2]/div[1]")).getText();
	}

	@Then("^The principal profile name should match with the actual principal name$")
	public void the_principal_profile_name_should_match_with_the_actual_principal_name() throws Throwable {
		String actual = "Name:Principal1";
		Assert.assertEquals(expected, actual);	
		
	}


}
