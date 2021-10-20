package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class RequestReject {
	public static WebDriver driver;
	@Given("^The admin request screen$")
	
	public void the_admin_request_screen() throws Throwable {
		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"request";
		driver.get(URL);
	//	driver.get("https://dev.smallmoves.org/request");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^The admin user clicks reject button$")
	public void the_admin_user_clicks_reject_button() throws Throwable {
		driver.findElement(By.id("searchOpen")).click();
		driver.findElement(By.id("searchOpen")).clear();
		driver.findElement(By.id("searchOpen")).sendKeys("Bala");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Reject")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();

	//	driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^The request should be rejected successfully$")
	public void the_request_should_be_rejected_successfully() throws Throwable {
		
	     driver.findElement(By.id("rejectReason")).click();
	     driver.findElement(By.id("rejectReason")).sendKeys("Rejected for testing purpose");
	     driver.findElement(By.className("principal_submit_btn")).click();
	     driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	     
	     driver.findElement(By.linkText("Ok")).click();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	     driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();
		String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		System.out.println("The value of alert is "+alertText);
		String expected = "Request rejected successfully";

		Assert.assertEquals(alertText, expected);

		driver.findElement(By.linkText("Ok")).click();	

	}


}
