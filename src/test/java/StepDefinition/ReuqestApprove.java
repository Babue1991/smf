package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class ReuqestApprove {

	public static WebDriver driver;
	@Given("^The admin user request screen$")
    public void the_admin_user_request_screen() throws Throwable {


		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"request";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("searchOpen")).click();
		driver.findElement(By.id("searchOpen")).clear();
		driver.findElement(By.id("searchOpen")).sendKeys("Kannan");
	}

    @When("^The admin user clicks approve button$")
    public void the_admin_user_clicks_approve_button() throws Throwable {
    	//driver.findElement(By.xpath("//*[@id=\"sidebarNav\"]/li[2]/a/span")).click();
	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("searchOpen")).click();
		driver.findElement(By.id("searchOpen")).clear();
		driver.findElement(By.id("searchOpen")).sendKeys("Kannan");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.findElement(By.linkText("Approve")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().alert().accept();

		driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

    @Then("^The request should be approved successfully$")
    public void the_request_should_be_approved_successfully() throws Throwable {
	    
	
		driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();

		String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		System.out.println("The value of alert is "+alertText);
		String expected = "Request approved successfully";

		Assert.assertEquals(alertText, expected);

		driver.findElement(By.linkText("Ok")).click();	
		
	}


}
