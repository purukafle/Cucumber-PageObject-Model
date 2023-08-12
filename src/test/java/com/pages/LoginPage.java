package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	private WebDriver driver;
	//By Loctors:
	
	private By emailId=By.id("email");
	private By password=By.id("password");
	private By signInButton=By.id("Submitlogin");
	private By forgotPaswordLInks=By.linkText("Forgot your password");
	//2. Costructor of the page class
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	//3. page action: features(behavior) of the page the form of method:
	
	public String getLoginPageTitle() {
		
		return driver.getTitle();
		
	}
	public boolean isForgotPWdLinkExist() {
		return driver.findElement(forgotPaswordLInks).isDisplayed();
		 
	}
	public void enterUserName(String username) {
		driver.findElement(emailId).sendKeys(username);
		
	}
	public void enterUserPassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
		
	}
	public void clickOnLogin() {
		driver.findElement(signInButton).click();
	}
	
	//1 hrs done
	//https://www.youtube.com/watch?v=NhiIAZRoc0g&t=467s

}
