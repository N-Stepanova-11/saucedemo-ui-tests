package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	WebDriver driver;
	WebDriverWait wait;
	public BasePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
	
	public void open(String url) {
		driver.get(url);
	}
	
	protected boolean isElementDisplayed(By locator) {
		return driver.findElement(locator).isDisplayed();
	}
}
