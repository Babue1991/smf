package StepDefinition;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestSuiteSetUp {


	@BeforeSuite(alwaysRun = true)
	public void setupSuite() {
		//		WebDriver driver = new FirefoxDriver();
		System.out.println("I'm inside test suite");
	}

	@AfterSuite(alwaysRun = true)
	public void tearDown() {
		//driver().close();

		System.out.println("I'm inside After suite");	
	}

}

