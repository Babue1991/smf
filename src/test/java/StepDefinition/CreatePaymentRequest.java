package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class CreatePaymentRequest {
	public static WebDriver driver;

	@Given("^The principal dashboard screen$")
	public void the_principal_dashboard_screen() throws Throwable {
		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);
	 //   driver.get("https://dev.smallmoves.org/dashboard");
		
		
	}

	@When("^I click create new request button$")
	public void i_click_create_new_request_button() throws Throwable {
		driver.findElement(By.cssSelector("button")).click();
		
	}

	@And("^I enter \"([^\"]*)\" and amount$")
    public void i_enter_something_and_amount(String beneficiaryname) throws Throwable {
	 
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("beneficiaryName")).click();
	    driver.findElement(By.id("beneficiaryName")).clear();
	    driver.findElement(By.id("beneficiaryName")).sendKeys(beneficiaryname);
	    driver.findElement(By.id("amount")).clear();
	    driver.findElement(By.id("amount")).sendKeys("100");
	}

	@When("^I select financial assitance and enter fund request reason$")
	public void i_select_financial_assitance_and_enter_fund_request_reason() throws Throwable {
	 
		driver.findElement(By.id("fundCategory")).click();
	    new Select(driver.findElement(By.id("fundCategory"))).selectByVisibleText("Other");
	    driver.findElement(By.id("fundReason")).click();
	    driver.findElement(By.id("fundReason")).clear();
	    driver.findElement(By.id("fundReason")).sendKeys("Test reason");
	}

	@When("^I select category and enter addtional information$")
	public void i_select_category_and_enter_addtional_information() throws Throwable {
	  
		driver.findElement(By.cssSelector("label.form-check-label")).click();
	    driver.findElement(By.xpath("//form[@id='createFund']/div/div[5]/div[2]/div[2]/label")).click();
	    driver.findElement(By.xpath("//form[@id='createFund']/div/div[5]/div[2]/div[3]/label")).click();
	    driver.findElement(By.id("additionalInformation")).click();
	    driver.findElement(By.id("additionalInformation")).clear();
	    driver.findElement(By.id("additionalInformation")).sendKeys("Optional");
	}

	@When("^I select payment method and I accept terms and conditions$")
	public void i_select_payment_method_and_I_accept_terms_and_conditions() throws Throwable {
	
		 driver.findElement(By.id("stateId")).click();
		    new Select(driver.findElement(By.id("stateId"))).selectByVisibleText("Paypal");
		    driver.findElement(By.cssSelector("div.form-check.pt-0.mt-2 > label.form-check-label")).click();
		    driver.findElement(By.id("submitButton")).click();

	}

	@Then("^The payment request should be created successfully$")
	public void the_payment_request_should_be_created_successfully() throws Throwable {
	  
		driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();

		String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		System.out.println("The value of alert is"+alertText);
		String expected = "Thank you for your submission. You will hear if this request has been approved within one business day, or on Monday if entered on a weekend.";

		Assert.assertEquals(alertText, expected);

		driver.findElement(By.linkText("Ok")).click();
	}

}

