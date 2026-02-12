package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;
	
	private By userNameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	
	public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
	
	public void open(String url) {
		driver.get(url);
	}
	
	public void enterUserName(String userName) {
		driver.findElement(userNameField).sendKeys(userName);
	}
	
	public void enterPassword(String password) {
		driver.findElement(passwordField).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(loginButton).click();
	}

}
