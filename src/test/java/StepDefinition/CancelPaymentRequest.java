package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class CancelPaymentRequest {
	public static WebDriver driver;
	@Given("^The principal users dashboard screen$")
	public void the_principal_users_dashboard_screen() throws Throwable {

		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);
	//	driver.get("https://dev.smallmoves.org/dashboard");
	}

	@When("^The principal user clicks cancel button$")
	public void the_principal_user_clicks_cancel_button() throws Throwable {
		driver.findElement(By.id("searchRequest")).click();
		driver.findElement(By.id("searchRequest")).clear();
		driver.findElement(By.id("searchRequest")).sendKeys("Manoj");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Cancel")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^The payment request should be cancelled successfully$")
	public void the_payment_request_should_be_cancelled_successfully() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();

		String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		System.out.println("The value of alert is "+alertText);
		String expected = "Request cancelled successfully";

		Assert.assertEquals(alertText, expected);

		driver.findElement(By.linkText("Ok")).click();	
	}
}
