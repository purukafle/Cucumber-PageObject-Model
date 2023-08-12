package com.stepdefinitions;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SearchLaptopSteps {

	private WebDriver driver = null;
	private String url = "https://www.google.com/";

	@Given("I open chrome browser")
	public void i_open_chrome_browser() {
		System.out.println("opening chrome browser.");
	}

	@When("I goto www.google.com website")
	public void i_goto_www_google_com_website() {
		driver.get(url);
	}

	@When("I enter Laptop")
	public void i_enter_laptop() {
		WebElement googleSearchField = driver.findElement(By.name("q"));
		googleSearchField.clear();
		googleSearchField.sendKeys("Laptop");
	}

	@When("I click Enter button")
	public void i_click_enter_button() {
		WebElement googleSearchField = driver.findElement(By.name("q"));
		googleSearchField.sendKeys(Keys.ENTER);

	}

	@Then("I should see search results for laptop")
	public void i_should_see_search_results_for_laptop() {
		// locate search area first
		WebElement searchArea = driver.findElement(By.id("search"));
		List<WebElement> searchResultTitles = searchArea.findElements(By.tagName("h3"));
		int counter = 1;
		for (WebElement elem : searchResultTitles) {
			String txt = elem.getText();
			if (txt.contains("Laptop")) {
				System.out.println("Result " + counter + ": " + txt);
				// break;
			}
			counter++;
		}
		//Intentionally failing the test here to generate error image in the 
		//cucumber html report
		//assertTrue(false);
	}


	@Then("I close chrome browser")
	public void i_close_chrome_browser() {
		System.out.println("closing chrome browser.");
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