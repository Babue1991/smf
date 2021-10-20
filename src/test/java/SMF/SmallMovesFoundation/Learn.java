package SMF.SmallMovesFoundation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Learn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		String URL = "http://demo.guru99.com/test/simple_context_menu.html";
		
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Actions action = new Actions(driver);
		WebElement element = driver.findElement(By.cssSelector("#authentication > span"));
//		action.doubleClick(element).perform();
		action.contextClick(element).perform();
		WebElement copy = driver.findElement(By.cssSelector("#authentication > ul > li.context-menu-item.context-menu-icon.context-menu-icon-copy > span"));
		copy.click();
	}

}
