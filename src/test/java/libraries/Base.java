package libraries;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;

import libraries.GlobalSelenium.Browser;

public class Base {
	public WebDriver driver;
	public GlobalSelenium myLibs=new GlobalSelenium();
	
	@BeforeClass
	public void beforeAllTest() {
		System.out.println("Running before all tests .......");
	}
	@AfterClass
	public void afterAllTest() {
		System.out.println("Running after all tests.");
		
	}
	@AfterMethod
	public void setUp() {
		driver=myLibs.startBrowser(Browser.CHROME);
	}
	
	
}
