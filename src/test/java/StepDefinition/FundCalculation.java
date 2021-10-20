package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;

public class FundCalculation {
	public static WebDriver driver;

	@Given("^I principal users dashboard$")
	public void i_principal_users_dashboard() throws Throwable {
		driver = DriverClass.initiate();
	    driver.get("https://dev.smallmoves.org/dashboard");
		
	}

	@When("^I add allocated fund and remaining fund$")
	public void i_add_allocated_fund_and_remaining_fund() throws Throwable {
	    
		String text = driver.findElement(By.cssSelector("#main > div > div:nth-child(3) > div.col-xxl-8.col-lg-8.col-md-8 > div > div.allocated_fund > h3")).getText();
		System.out.println(text);
		String remaining = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[3]/div[2]/div/div[3]/h3")).getText();
		System.out.println(remaining);
		System.out.println(text+remaining);
	}

	@Then("^The fund should match with total allocated fund$")
	public void the_fund_should_match_with_total_allocated_fund() throws Throwable {
	    
		
	}


}
