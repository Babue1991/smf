package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.*;

public class FundRequestSearch {
	public static WebDriver driver;
	@Given("^The fund request management section$")
	public void the_fund_request_management_section() throws Throwable {

		driver = DriverClass.initiate();
		String URL = Constants.baseUrl+"request";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^I enter search text in request management$")
	public void i_enter_search_text_in_request_management() throws Throwable {
		
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("window.scrollBy(0,1000)");
		 */
		  
		driver.findElement(By.cssSelector("input#searchProcessed")).click();
		driver.findElement(By.cssSelector("input#searchProcessed")).clear();

        
		driver.findElement(By.cssSelector("input#searchProcessed")).sendKeys("Justine Cordova");

	//	driver.findElement(By.id("searchRequest")).sendKeys("beneficiaryname");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

    @Then("^The request search result should show result based on search keyword$")
    public void the_request_search_result_should_show_result_based_on_search_keyword() throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actual = driver.findElement(By.xpath("//*[contains(text(),'Jose de Diego')]")).getText();
	//	driver.findElement(By.xpath("//table[@id='processed']/tbody/tr/td[2]")).click();
		System.out.println(actual);
		String expected = "Jose de Diego";
		Assert.assertEquals(actual, expected);
	}


}
