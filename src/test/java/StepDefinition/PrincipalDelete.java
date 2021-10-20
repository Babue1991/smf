package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.*;
import junit.framework.Assert;

public class PrincipalDelete {
	static WebDriver driver;
	@Given("^The principal management screen$")
	public void the_principal_management_screen() throws Throwable {

		driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);

		String schoolName = driver.findElement(By.xpath("//table[@id='PrincipalsList']/tbody/tr/td[2]")).getText();
	
		try {
				if(schoolName.contains("Selenium")) {
			
					System.out.println("The school name is"+schoolName);
					driver.findElement(By.linkText("Delete")).click();
					driver.switchTo().alert().accept();
			}
		}catch(Exception e) {
			System.out.println("No such school present");
		}

	}

	@When("^I click delete button from principal management$")
	public void i_click_delete_button_from_principal_management() throws Throwable {

	//	driver.findElement(By.linkText("Delete")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	//	driver.switchTo().alert().accept();
	}

	@Then("^The pricipal should be deleted successfully\\.$")
	public void the_pricipal_should_be_deleted_successfully() throws Throwable {

	//	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.id("modal-alert-msg")).click();
		String expected = driver.findElement(By.id("modal-alert-msg")).getText();
		String actual = "Principal deleted successfully";
		Assert.assertEquals(expected, actual);
		System.out.println("The delete message is"+expected);
		driver.findElement(By.linkText("Ok")).click();
		
		}
}
