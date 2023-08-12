package AppHooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.gherkin.model.Scenario;
import com.qa.factory.DriverFactory;
import com.qa.utils.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class ApplicationHooks {
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	@Before(order = 0)
	public void getProperty() {
		configReader=new ConfigReader();
		prop=configReader.init_prop();
		
	}
	@Before(order = 1)
	public void launchBrowser() {
		String browserName=prop.getProperty("browser");
		driverFactory=new DriverFactory();
		driver=driverFactory.init_driver(browserName);
		
	}
	@After(order = 0)
	public void quiteBrowser() {
		driver.quit();
	}
	@After(order = 1)
	public void tearDown(Scenario scenario) {
		if(scenario.isFailed()) {
			//take a screen shot
		String screenshotName=scenario.getName().replaceAll(" ","_");
		byte [] sourcePath=((TakeScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(sourcePath, "image/png", screenshotName);
		
		//44 minutes is done
		//https://www.youtube.com/watch?v=NhiIAZRoc0g&t=467s
		
			
		}
		
	}
	
	

}
