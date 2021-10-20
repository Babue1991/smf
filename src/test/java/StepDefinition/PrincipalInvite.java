package StepDefinition;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Random;
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

public class PrincipalInvite {

	static  WebDriver driver;
	String baseUrl;
	JavascriptExecutor js;

	@Given("^The admin dashboard with principal managment section$")
	public void the_admin_dashboard_with_principal_managment_section() throws Throwable {		

		driver = DriverClass.initiate();
		//driver = DriverClass.initiate();
		String URL=Constants.baseUrl+"dashboard";
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^I click invite principal button$")
	public void i_click_invite_principal_button() throws Throwable {
		driver.findElement(By.cssSelector("button.invite_btn")).click();		
	}

	@When("^I enter principal name and email$")
	public void i_enter_principal_name_and_email() throws Throwable {

		String principalName = "Principal";
		Random random = new Random();
		int y = random.nextInt(1000);   
		String principalName1= principalName+y;
		System.out.println(principalName1);

		driver.findElement(By.id("principal-name")).click();
		driver.findElement(By.id("principal-name")).clear();
		driver.findElement(By.id("principal-name")).sendKeys(principalName1);
		driver.findElement(By.id("principal-email")).clear();
		driver.findElement(By.id("principal-email")).sendKeys(principalName1+"@yopmail.com");

	}

	@When("^I select principal list and click invite button$")
	public void i_select_principal_list_and_click_invite_button() throws Throwable {
		driver.findElement(By.id("principal-school")).click();
		new Select(driver.findElement(By.id("principal-school"))).selectByVisibleText("Selenium");
		driver.findElement(By.id("inviteBtn")).click();
	}

	@Then("^The principal invite should be successful$")
	public void the_principal_invite_should_be_successful() throws Throwable {

		driver.findElement(By.linkText("Ok")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//*[@id=\"modal-alert-msg\"]")).click();

		String alertText = driver.findElement(By.cssSelector("#modal-alert-msg")).getText();
		System.out.println("The value of alert is"+alertText);
		String expected = "Principal Invited successfully";

		Assert.assertEquals(alertText, expected);

		driver.findElement(By.linkText("Ok")).click();
	}
}


