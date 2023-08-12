package com.qa.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver>tDriver=new ThreadLocal<>();
	
	/**
	 * 
	 * this methd is used to initialize the thradelocal driver on the basis of given browser
	 * @return
	 */
	
	public WebDriver init_driver(String browser) {
		System.out.println("browser values is: "+browser);
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
			
		}
		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			tDriver.set(new FirefoxDriver());
			
		}
		else if (browser.equals("safari")) {
			WebDriverManager.safaridriver().setup();
			tDriver.set(new SafariDriver());
			
		}
		else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			tDriver.set(new EdgeDriver());
			
		}
		else {
			System.out.println("invalid driver connect to the chrome dricer as a default driver");
			WebDriverManager.chromedriver().setup();
			tDriver.set(new ChromeDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();
		
	}
	/**
	 * this is used to get the driver with thread local
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tDriver.get();
	}

}
