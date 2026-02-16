package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{
	
	private By userNameField = By.id("user-name");
	private By passwordField = By.id("password");
	private By loginButton = By.id("login-button");
	private By errorButton = By.className("error-button");
	
	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
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
	
	public void authorize(String userName, String password) {
		enterUserName(userName);
		enterPassword(password);
		clickLoginButton();
	}
	
	public boolean errorButtonisDisplayed() {
		return isElementDisplayed(errorButton);
		//return driver.findElement(errorButton).isDisplayed();
	}

}
