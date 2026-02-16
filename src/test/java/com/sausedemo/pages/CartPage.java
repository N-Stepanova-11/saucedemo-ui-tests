package com.sausedemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage{
	By cartTitle = By.xpath("//span[text()='Your Cart']");

	public CartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	}
	
	public boolean isDisplayed() {
		return isElementDisplayed(cartTitle);
	}
}
