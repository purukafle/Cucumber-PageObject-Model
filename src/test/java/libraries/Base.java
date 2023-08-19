package libraries;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.ITestResult;
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
	
	@AfterMethod
	public void tearDown(ITestResult result) {
		
		if(ITestResult.FAILURE == result.getStatus()) {
			// capture screenshot when test fails
			myLibs.takeScreenshot(result.getName());
		}
		
		
		myLibs.tearDown();
		
	}
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
		driver.manage().window().maximize();
	}
	
	@After
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			String testName = scenario.getName();
			// take a screenshot
      		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      		// embed screenshot into cucumber report
      		scenario.attach(screenshot, "image/png", testName);
		}
		
		if(driver != null) {
			driver.quit();
		}
	}
	

	
}
