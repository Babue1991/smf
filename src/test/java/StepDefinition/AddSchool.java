package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import cucumber.api.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AddSchool {
	static  WebDriver driver;
	 String baseUrl;
	 JavascriptExecutor js;

	 @Given("^The admin dashboard screen$")
	 public void the_admin_dashboard_screen() throws Throwable {
		

		driver = DriverClass.initiate();
	      
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);
	
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(2000L);
			 js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(2000L);
		 
		
	}

	 @When("^I click add new school button$")
	 public void i_click_add_new_school_button() throws Throwable {
		 driver.findElement(By.cssSelector("#schoolManagement > div.col-lg-12 > div.table_head_section.d-flex.align-items-center > div.ml-auto.d-flex.data_search_form > button.invite_btn")).click();
	
	}

	 @When("^I enter school name$")
	 public void i_enter_school_name() throws Throwable {

		 	driver.findElement(By.id("school-name")).click();
		    driver.findElement(By.id("school-name")).clear();
		    driver.findElement(By.id("school-name")).sendKeys("Selenium");			    

	}

	 @When("^I enter enter street address, city and State$")
	 public void i_enter_enter_street_address_city_and_State() throws Throwable {
		 	driver.findElement(By.id("streetAddress")).clear();
		    driver.findElement(By.id("streetAddress")).sendKeys("Windows");
		    driver.findElement(By.id("city")).clear();
		    driver.findElement(By.id("city")).sendKeys("WebDriver");
		    driver.findElement(By.id("stateId")).click();
		    new Select(driver.findElement(By.id("stateId"))).selectByVisibleText("Arizona");
	}

	 @When("^I enter zip code and phone number and clicks submit button$")
	 public void i_enter_zip_code_and_phone_number_and_clicks_submit_button() throws Throwable {


			driver.findElement(By.id("zipCode")).click();
		    driver.findElement(By.id("zipCode")).clear();
		    driver.findElement(By.id("zipCode")).sendKeys("12345");
		    driver.findElement(By.id("phone")).clear();
		    driver.findElement(By.id("phone")).sendKeys("2234567890");
		  //  driver.findElement(By.cssSelector("#addNewSchool > div.row")).click();
    
	
	}

	 @Then("^The school should be created successfully$")
	 public void the_school_should_be_created_successfully() throws Throwable {
	
		 driver.findElement(By.id("schoolAddButton")).click();
			
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
		driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();
		
		 
		 String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		 System.out.println("The value of alert is"+alertText);
		 String expected = "School created successfully";
		    
		Assert.assertEquals(alertText, expected);
		
		driver.findElement(By.linkText("Ok")).click();
	}

	
}
