package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverClass {
	public static WebDriver driver;
	
	public static WebDriver initiate() {
		if(driver == null) {
		
		WebDriverManager.chromedriver().setup();
	 	driver = new ChromeDriver();
	 	driver.manage().window().maximize();
		}
	 	return driver;
		
	}
}
